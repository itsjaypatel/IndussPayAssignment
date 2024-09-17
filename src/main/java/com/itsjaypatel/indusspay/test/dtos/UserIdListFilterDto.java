package com.itsjaypatel.indusspay.test.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserIdListFilterDto {

    private List<Long> userIds;
}
