xcodebuild -workspace YourApp.xcworkspace -scheme YourAppUITests -sdk iphoneos -destination 'platform=iOS,id=<device-id>' test > test_results.log