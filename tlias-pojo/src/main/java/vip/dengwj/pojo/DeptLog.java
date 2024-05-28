package vip.dengwj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptLog {
    private Integer id;
    private String log;
    private LocalDateTime createTime;
}
