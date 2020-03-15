package com.yamari.idddd.application.users;

import com.yamari.idddd.domain.models.users.IUserRepository;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;

public class UserDeleteService {

  IUserRepository userRepository;

  public UserDeleteService(IUserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public void delete(UserDeleteCommand command) {
    UserId targetId = new UserId(command.getId());
    User user = userRepository.find(targetId);

    if (user == null) {
      // 削除対象のユーザが見つからない場合は退会成功とする
      return;
    }

    userRepository.delete(user);
  }
}
