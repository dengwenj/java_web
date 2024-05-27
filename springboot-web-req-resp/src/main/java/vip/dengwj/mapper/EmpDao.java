package vip.dengwj.mapper;

import vip.dengwj.pojo.Emp;

import java.util.List;

public interface EmpDao {
    public abstract List<Emp> getEmpList() throws Exception;
}
