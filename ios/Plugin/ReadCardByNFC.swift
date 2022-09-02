import Foundation

@objc public class ReadCardByNFC: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
