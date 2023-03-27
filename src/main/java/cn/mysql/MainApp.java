package cn.mysql;

import cn.mysql.entity.ColumnProp;
import cn.mysql.entity.Connection;
import cn.mysql.util.CompareUtil;
import cn.mysql.util.MySQLUtil;

import java.io.FileWriter;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MainApp {

    private static String SRC_HOST;
    private static String SRC_DBNAME;
    private static String SRC_USERNAME;
    private static String SRC_USERPWD;

    public static volatile Map<String, String> ignoreFieldNameMap = new ConcurrentHashMap<>();

    public static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    /**
     * 把要被的对比的库注册到这里来
     * Map的key只是打印出来的库的名字，对结果没有影响
     */
    public static void init() {
        //初始化源库
        SRC_HOST = "10.10.102.211:30036";
        SRC_DBNAME = "dev-app-management";
        SRC_USERNAME = "root";
        SRC_USERPWD = "lE34lyMhtP";

        //初始化被对比库
        connectionMap.put("uat", new Connection("10.10.103.237:30036", "yanlian-app-management", "root", "VRuBjIdqd8"));
        connectionMap.put("prod", new Connection("10.10.103.237:30036", "prod-project_manage_platform", "root", "VRuBjIdqd8"));
    }

    public static void main(String[] args) throws Exception {
        //初始化
        init();

        Map<String, Map<String, ColumnProp>> dbAInfo = MySQLUtil.getDBInfo(SRC_HOST, SRC_DBNAME, SRC_USERNAME, SRC_USERPWD);
        StringBuffer result = new StringBuffer();
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {

            System.out.println("==========" + entry.getKey() + "库对比开始==========");

            Connection connection = entry.getValue();
            Map<String, Map<String, ColumnProp>> dbBInfo = MySQLUtil.getDBInfo(connection.getHost(), connection.getDBName(), connection.getUserName(), connection.getPassWord());
            String compareResult = CompareUtil.compareDBInfo(dbAInfo, dbBInfo);
            System.out.println(compareResult);

            result.append("==========" + entry.getKey() + "库对比结果==========\n\n");
            result.append(compareResult);
        }

        //保存结果
        String filePath = "D:\\WorkTemp\\java-collection\\database\\mysql-compare\\DBCompareResult.txt";
        FileWriter writer = new FileWriter(filePath);
        writer.write(result.toString());
        writer.close();
    }

}
