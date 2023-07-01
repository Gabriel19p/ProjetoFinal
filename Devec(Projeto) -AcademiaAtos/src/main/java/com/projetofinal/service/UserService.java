package com.projetofinal.service;

import com.projetofinal.model.UserDtls;

public interface UserService {

    public UserDtls createUser(UserDtls user);

    public boolean checkEmail(String email);

}
