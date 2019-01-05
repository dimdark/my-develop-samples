/**
 * @author dimdark
 */
public interface CodeGeneratorConfiguration {

    String URL = "jdbc:mysql://localhost:3306/hsmall?useUnicode=true&useSSL=false&characterEncoding=utf8";
    String DRIVER_NAME = "com.mysql.jdbc.Driver";
    String USERNAME = "root";
    String PASSWORD = "wang5228";
    String[] INCLUDE_TABLE_NAMES = {"hsmall_cart", "hsmall_category", "hsmall_order", "hsmall_order_item",
                            "hsmall_pay_info", "hsmall_product", "hsmall_shipping", "hsmall_user"};

    boolean LOMBOK_USE = false;

    String COMMON_PACKAGE_NAME = "com.hsmall";

}
