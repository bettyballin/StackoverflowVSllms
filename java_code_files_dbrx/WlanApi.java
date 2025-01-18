import com.sun.jna.*;
import com.sun.jna.win32.StdCallLibrary;
import com.sun.jna.win32.W32APIOptions;
import com.sun.jna.ptr.*;
import com.sun.jna.platform.win32.WinNT;
import java.util.Arrays;
import java.util.List;

public class WlanApi {
    // Constants from native libraries:
    public static final int ERROR_SUCCESS = 0x0;
    public static final int MAX_SSID_LEN = 32;

    public static final WlanApiLoader INSTANCE = Native.load("wlanapi", WlanApiLoader.class, W32APIOptions.UNICODE_OPTIONS);

    public interface WlanApiLoader extends StdCallLibrary {
        int WlanOpenHandle(int dwClientVersion, Pointer pReserved, IntByReference pdwNegotiatedVersion, WinNT.HANDLEByReference phClientHandle);
        int WlanEnumInterfaces(WinNT.HANDLEByReference hClientHandle, Pointer pReserved, PointerByReference ppInterfaceList);
        void WlanFreeMemory(Pointer pMemory);
        int WlanGetAvailableNetworkList(WinNT.HANDLEByReference hClientHandle, GUID pInterfaceGuid, int dwFlags, Pointer pReserved, PointerByReference ppAvailableNetworkList);
        int WlanCloseHandle(WinNT.HANDLEByReference hClientHandle, Pointer pReserved);
    }

    public static class GUID extends Structure {
        public int Data1;
        public short Data2;
        public short Data3;
        public byte[] Data4 = new byte[8];

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("Data1", "Data2", "Data3", "Data4");
        }
    }

    public static class WLAN_INTERFACE_INFO extends Structure {
        public GUID InterfaceGuid;
        public char[] strInterfaceDescription = new char[256]; // WLAN_MAX_NAME_LENGTH is 256
        public int isState; // WLAN_INTERFACE_STATE enum

        public WLAN_INTERFACE_INFO() {}

        public WLAN_INTERFACE_INFO(Pointer p) {
            super(p);
            read();
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("InterfaceGuid", "strInterfaceDescription", "isState");
        }
    }

    public static class WLAN_INTERFACE_INFO_LIST extends Structure {
        public int dwNumberOfItems;
        public int dwIndex;
        public WLAN_INTERFACE_INFO[] InterfaceInfo;

        public WLAN_INTERFACE_INFO_LIST(Pointer p) {
            super(p);
            read();
            InterfaceInfo = new WLAN_INTERFACE_INFO[dwNumberOfItems];
            int offset = size();
            for (int i = 0; i < dwNumberOfItems; i++) {
                InterfaceInfo[i] = new WLAN_INTERFACE_INFO(p.share(offset));
                offset += InterfaceInfo[i].size();
            }
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("dwNumberOfItems", "dwIndex", "InterfaceInfo");
        }
    }

    public static class DOT11_SSID extends Structure {
        public int uSSIDLength;
        public byte[] ucSSID = new byte[32];

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("uSSIDLength", "ucSSID");
        }
    }

    public static class WLAN_AVAILABLE_NETWORK extends Structure {
        public char[] strProfileName = new char[256];
        public DOT11_SSID dot11Ssid;
        public int dot11BssType;
        public int uNumberOfBssids;
        public boolean bNetworkConnectable;
        public int wlanNotConnectableReason;
        public int uNumberOfPhyTypes;
        public int[] dot11PhyTypes = new int[8];
        public boolean bMorePhyTypes;
        public int wlanSignalQuality;
        public boolean bSecurityEnabled;
        public int dot11DefaultAuthAlgorithm;
        public int dot11DefaultCipherAlgorithm;
        public int dwFlags;
        public int dwReserved;

        public WLAN_AVAILABLE_NETWORK() {
            dot11Ssid = new DOT11_SSID();
        }

        public WLAN_AVAILABLE_NETWORK(Pointer p) {
            super(p);
            read();
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList(
                "strProfileName", "dot11Ssid", "dot11BssType", "uNumberOfBssids", "bNetworkConnectable",
                "wlanNotConnectableReason", "uNumberOfPhyTypes", "dot11PhyTypes", "bMorePhyTypes", "wlanSignalQuality",
                "bSecurityEnabled", "dot11DefaultAuthAlgorithm", "dot11DefaultCipherAlgorithm", "dwFlags", "dwReserved"
            );
        }
    }

    public static class WLAN_AVAILABLE_NETWORK_LIST extends Structure {
        public int dwNumberOfItems;
        public int dwIndex;
        public WLAN_AVAILABLE_NETWORK[] Network;

        public WLAN_AVAILABLE_NETWORK_LIST(Pointer p) {
            super(p);
            read();
            Network = new WLAN_AVAILABLE_NETWORK[dwNumberOfItems];
            int offset = size();
            for (int i = 0; i < dwNumberOfItems; i++) {
                Network[i] = new WLAN_AVAILABLE_NETWORK(p.share(offset));
                offset += Network[i].size();
            }
        }

        @Override
        protected List<String> getFieldOrder() {
            return Arrays.asList("dwNumberOfItems", "dwIndex", "Network");
        }
    }

    public static void main(String[] args) {
        WinNT.HANDLEByReference phClientHandle = new WinNT.HANDLEByReference();
        int version = 2;
        IntByReference negotiatedVersion = new IntByReference();
        int result = INSTANCE.WlanOpenHandle(version, null, negotiatedVersion, phClientHandle);
        if (result != ERROR_SUCCESS) {
            System.err.println("Error opening WLAN handle: " + result);
            return;
        }

        PointerByReference ppInterfaceList = new PointerByReference();
        result = INSTANCE.WlanEnumInterfaces(phClientHandle, null, ppInterfaceList);
        if (result != ERROR_SUCCESS) {
            System.err.println("Error enumerating interfaces: " + result);
            INSTANCE.WlanCloseHandle(phClientHandle, null);
            return;
        }

        WLAN_INTERFACE_INFO_LIST interfaceList = new WLAN_INTERFACE_INFO_LIST(ppInterfaceList.getValue());
        for (int i = 0; i < interfaceList.dwNumberOfItems; i++) {
            WLAN_INTERFACE_INFO info = interfaceList.InterfaceInfo[i];
            String description = Native.toString(info.strInterfaceDescription);
            System.out.println("Interface Description: " + description);
            System.out.println("State: " + info.isState);

            PointerByReference ppAvailableNetworkList = new PointerByReference();
            result = INSTANCE.WlanGetAvailableNetworkList(phClientHandle, info.InterfaceGuid, 0, null, ppAvailableNetworkList);
            if (result != ERROR_SUCCESS) {
                System.err.println("Error getting available network list: " + result);
                continue;
            }

            WLAN_AVAILABLE_NETWORK_LIST networkList = new WLAN_AVAILABLE_NETWORK_LIST(ppAvailableNetworkList.getValue());
            for (int j = 0; j < networkList.dwNumberOfItems; j++) {
                WLAN_AVAILABLE_NETWORK network = networkList.Network[j];
                String ssid = new String(network.dot11Ssid.ucSSID, 0, network.dot11Ssid.uSSIDLength);
                System.out.println("Available Network SSID: " + ssid);
            }
            INSTANCE.WlanFreeMemory(ppAvailableNetworkList.getValue());
        }
        INSTANCE.WlanFreeMemory(ppInterfaceList.getValue());
        INSTANCE.WlanCloseHandle(phClientHandle, null);
    }
}