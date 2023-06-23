import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(GreatDayMapsPlugin)
public class GreatDayMapsPlugin: CAPPlugin {
    // private let implementation = GreatDayMaps()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": ""
        ])
    }
}