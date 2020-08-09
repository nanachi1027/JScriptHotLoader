// 传入全局参数, 传入 function 不同参数

// function 返回基本类型参数, function 返回对象实例参数, function 将返回参数放置到全局变量中, 对全局变量进行重写

/**
 simple_config.js 主要进行简单类型的计算,
 input: 仅限基本类型 & 无传入参数;
 output: 仅限基本类型 & 无返回类型
 返回复杂类型或是多参数, 通过 env_context: Map<String, Object> 全局变量来进行设置.
 env_context: Map<String, Object> 是全局变量, 在 java 代码中, 设置好了初始值之后,
 传入到 java script context 中.

 同时, 为了更加贴近线上配置环境, 我们将配置信息的解析使用 spark.conf 中的配置关键字来标识.
*/


// spark param: spark.cores.max, represented by 'sparkCoresMaxEnabled' this global param
// input: sparkCoresMaxEnabled: boolean
// output: spark.cores.max:int
function sparkCoresMax() {
    if (sparkCoresMaxEnabled) {
        return 20;
    } else {
        return 0;
    }
}
