import java.util.List;
import java.util.ArrayList;

import android.graphics.drawable.Drawable;
import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;
import com.google.android.maps.GeoPoint;

public class MyItemizedOverlay extends ItemizedOverlay<OverlayItem> {
  private List<OverlayItem> items;

  public MyItemizedOverlay(Drawable defaultMarker) {
    super(boundCenterBottom(defaultMarker));
    items = new ArrayList<OverlayItem>();
    for (int i = 0; i < 5; i++) {
      Double lat = (i+37.422006)*1E6;
      Double lng = -122.084095*1E6;
      GeoPoint point = new GeoPoint(lat.intValue(), lng.intValue());
      OverlayItem oi = new OverlayItem(point, "Marker", "Marker Text");
      items.add(oi);
    }
    populate();
  }

  @Override
  protected OverlayItem createItem(int index) {
    return items.get(index);
  }

  @Override
  public int size() {
    return items.size();
  }

  public static void main(String[] args) {
  }
}