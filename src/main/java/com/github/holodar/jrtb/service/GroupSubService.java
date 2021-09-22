package com.github.holodar.jrtb.service;

import com.github.holodar.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.holodar.jrtb.repository.entity.GroupSub;

import java.util.Optional;
import java.util.List;

public interface GroupSubService {

    GroupSub save(Long chatId, GroupDiscussionInfo groupDiscussionInfo);
    GroupSub save(GroupSub groupSub);

    Optional<GroupSub> findById(Integer id);

    List<GroupSub> findAll();
}
