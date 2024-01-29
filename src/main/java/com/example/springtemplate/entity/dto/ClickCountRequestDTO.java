package com.example.springtemplate.entity.dto;

import com.example.springtemplate.enums.YesOrNot;
import lombok.Data;

@Data
public class ClickCountRequestDTO {
    int clickCount;
    YesOrNot yesOrNot;
}
