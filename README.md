JsScriptHotLoader 的作用是支持 JVM 运行期间修改 js 文件之后, 在不需要重启 JVM/Service 的前提下能够热加载指定路径下的 JS 文件内容到 JVM 中.
适用在常驻服务中作为模块来调用,避免每次修改配置信息之后都需要重启服务来加载配置文件中的信息到服务上下文中.   