package com.example.webservice;

import com.zipe.model.User;
import com.zipe.util.WebServiceClientUtil;
import javax.xml.namespace.QName;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

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
            exampleWebServiceTest.getUserNameByDynamicClient();
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
        System.out.println("返回結果:" + result[0]);
    }
    private void getUserNameByDynamicClient() throws Exception {
        try {
            // 代理工廠
            JaxWsDynamicClientFactory jaxWsDynamicClientFactory = JaxWsDynamicClientFactory.newInstance();
            // 設置代理地址
            Client client = jaxWsDynamicClientFactory.createClient(WEB_SERVICE_URL);
            // 設置targetNamespace 和 methodName
            QName qname = new QName("http://service.example.com", "getUserName");
            Object[] result = client.invoke(qname, "01");

            System.out.println("返回結果:" + result[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
