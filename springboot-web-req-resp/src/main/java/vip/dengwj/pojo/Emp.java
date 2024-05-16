package vip.dengwj.pojo;

public class Emp {
    private String name;
    private int age;
    private String gender;
    private String job;

    public Emp() {
    }

    public Emp(String name, int age, String gender, String job) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.job = job;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return job
     */
    public String getJob() {
        return job;
    }

    /**
     * 设置
     * @param job
     */
    public void setJob(String job) {
        this.job = job;
    }

    public String toString() {
        return "Emp{name = " + name + ", age = " + age + ", gender = " + gender + ", job = " + job + "}";
    }
}
