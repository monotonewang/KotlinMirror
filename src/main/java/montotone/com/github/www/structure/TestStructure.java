package montotone.com.github.www.structure;

public class TestStructure {


    public static void main(String... args){

        TestOverloadFuncation testOverloadFuncation = new TestOverloadFuncation();

        //不传递参数使用默认参数
        String xx = testOverloadFuncation.xx();

        System.out.println(xx);
    }

}
