package vip.dengwj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private String id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
