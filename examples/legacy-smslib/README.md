# 历史 SMSLib 串口示例

本目录保存原来放在 `src/test/java/org/smslib/` 的 11 个串口、调制解调器和短信示例，源码未改动。这些文件通过 `main` 方法连接真实硬件，没有 JUnit 测试方法；当前仓库的产物是 Commons VFS Starter，POM 不声明 SMSLib 与串口库。将示例从 Maven 测试源码目录移出后，VFS 的构建和测试不会因无关的历史硬件 API 而编译失败。需要使用这些示例时，须在独立的 SMSLib 工程中配置相应版本及设备。
