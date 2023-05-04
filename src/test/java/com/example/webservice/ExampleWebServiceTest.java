package com.example.webservice;

import com.zipe.model.User;
import com.zipe.util.WebServiceClientUtil;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * @author : Gary Tsai
 * @created : @Date 2021/5/4 下午 02:55
 **/
public class ExampleWebServiceTest {
    private final String WEB_SERVICE_URL = "http://localhost:8080/example/webservice/example?wsdl";
    public static void main(String[] args) throws Exception {
        try {
            ExampleWebServiceTest exampleWebServiceTest = new ExampleWebServiceTest();
            exampleWebServiceTest.getUserByProxy();
            exampleWebServiceTest.getUserByClientUtil();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUserByProxy(){
        try {
            // 代理工廠
            JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
            // 設置代理地址
            jaxWsProxyFactoryBean.setAddress(WEB_SERVICE_URL);
            // 設置接口類型
            jaxWsProxyFactoryBean.setServiceClass(ExampleWebService.class);
            // 創建一個代理接口實現
            ExampleWebService us = (ExampleWebService) jaxWsProxyFactoryBean.create();
            // 數據准備
            String userId = "02";
            // 調用代理接口的方法調用並返回結果
            User result = us.getUser(userId);
//            Map<String, User> userMaps= us.getAllUserData();
            System.out.println("返回結果:" + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getUserByClientUtil() throws Exception {
        WebServiceClientUtil clientUtil = new WebServiceClientUtil(
            WEB_SERVICE_URL, "getUser", new Object[]{"01"});
        Object[] result = clientUtil.invoke();
        for (Object o : result) {
            System.out.println(o);
        }
    }
}
