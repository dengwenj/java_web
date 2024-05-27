package vip.dengwj.mapper.impl;

import org.springframework.stereotype.Repository;
import vip.dengwj.mapper.EmpDao;
import vip.dengwj.pojo.Emp;
import vip.dengwj.util.XMLParse;

import java.util.List;
import java.util.Objects;

//@Component // 将当前类交给 IOC 容器管理，成为 IOC 容器中的 bean
@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> getEmpList() throws Exception {
        String file = Objects.requireNonNull(this.getClass().getClassLoader().getResource("emp.xml")).getFile();
        // System.out.println(file); // /Users/dengwenjie/Java/java_web/springboot-web-req-resp/target/classes/emp.xml
        // "springboot-web-req-resp/src/main/resources/emp.xml"
        List<Emp> list = XMLParse.xmlParse(file, Emp.class);
        return list;
    }
}
