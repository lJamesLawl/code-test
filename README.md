For a given string that only contains alphabet characters a-z, if 3 or more consecutive 
characters are identical, remove them from the string. Repeat this process until 
there is no more than 3 identical characters sitting besides each other. 
Example: 
Input: aabcccbbad 
Output: -> aabbbad -> aaad -> d

#Stage 2 - advanced requirement 
Instead of removing the consecutively identical characters, replace them with a 
single character that comes before it alphabetically. 
Example: 
ccc -> b 
bbb -> a 
Input: abcccbad 
Output: -> abbbad, ccc is replaced by b -> aaad, bbb is replaced by a -> d



## Requirements

Java 11+

Maven 3.6+



## 功能说明

- 支持两种模式（Basic / Advanced）
- 使用工厂模式创建处理器
- 输入校验（仅允许 a-z）
- 提供完整单元测试

## 使用方式

```bash
mvn clean install
mvn test