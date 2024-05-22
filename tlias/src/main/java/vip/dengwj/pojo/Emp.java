package vip.dengwj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private String id;
    private String username;
    private String name;
    private short gender;
    private String image;
    private short job;
    private LocalDate entryDate;
    private short deptId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
