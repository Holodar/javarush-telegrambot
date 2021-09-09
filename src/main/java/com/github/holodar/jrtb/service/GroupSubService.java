package com.github.holodar.jrtb.service;

import com.github.holodar.jrtb.javarushclient.dto.GroupDiscussionInfo;
import com.github.holodar.jrtb.repository.entity.GroupSub;

public interface GroupSubService {

    GroupSub save(String chatId, GroupDiscussionInfo groupDiscussionInfo);
}
