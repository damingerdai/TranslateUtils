#  TranslateUtils说明

## 一、*TranslateUtils简介*
TransulateUitls是基于java的翻译工具类。
使用的翻译引擎：
* 有道翻译 (已经实现)
* 百度翻译 (已经实现)
* Google翻译 (正在实现)
* 金山翻译(尚未实现)
* 必应翻译(考虑实现)

## 二、*核心类说明*
### 1.Dispatch接口说明
	[Dispatch][]接口是TranslateUtils的核心接口，只有[translate][]这一个方法。
	[translate][]方法一共有三个参数：
	* from为Language类型，表示需要翻译文本的原始语言
	* targ为Language类型，表示需要翻译文本的目标语言
	* query为String类型，表示需要翻译的文本
	[translate][]方法的返回值是一个JSON格式的
### 2.YoudaoDispatch说明
	[YoudaoDispatch][]是基于有道翻译的Dispatch接口的具体实现。

## 三、*使用示例*
### 1.YoudaoDispatch使用示例
```JAVA
public class YoudaoDispathTest {

	@Test
	public void testYoudaoDispatch(){
		Dispatch d = new YoudaoDispatch();
		System.out.println(d.translate(Language.EN, Language.ZH_CN,"hello"));
	}
}
```
返回结果：
>{
    "type": "EN2ZH_CN",
    "errorCode": 0,
    "elapsedTime": 0,
    "translateResult": [
        [
            {
                "src": "hello",
                "tgt": "你好"
            }
        ]
    ],
    "smartResult": {
        "type": 1,
        "entries": [
            "",
            "n. 表示问候， 惊奇或唤起注意时的用语",
            "int. 喂；哈罗",
            "n. (Hello)人名；(法)埃洛"
        ]
    }
}
### 2.BaiduDispatch使用示例
```JAVA
public class BaiduDispatchTest {
	
	@Test
	public void translateTest() {
		Dispatch d = new BaiduDispatch();
		System.out.println(d.translate(Language.ZH_CN, Language.EN,"你好"));
	}
	
	 
}
```
返回结果(节选)：
>{
    "trans_result": {
        "from": "en",
        "to": "zh",
        "domain": "all",
        "type": 2,
        "status": 0,
        "data": [
            {
                "dst": "你好",
                "src": "hello",
                "relation": [],
                "result": [
                    [
                        0,
                        "你好",
                        [
                            "0|5"
                        ],
                        [],
                        [
                            "0|5"
                        ],
                        [
                            "0|6"
                        ]
                    ]
                ]
            }
        ],
        
***
*源代码*
[github](https://github.com/damingerdai/TranslateUtils](https://github.com/damingerdai/TranslateUtils))
