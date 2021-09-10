package com.rz.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0 2021/9/10
 * @outhor Likefr
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class contents {
    private int id;
    private String title;
    private String text;
    private String date;
}
