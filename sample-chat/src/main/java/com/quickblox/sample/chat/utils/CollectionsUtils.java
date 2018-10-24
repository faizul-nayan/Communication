package com.quickblox.sample.chat.utils;

import com.quickblox.chat.model.QBAttachment;
import com.quickblox.core.helper.StringifyArrayList;
import com.quickblox.users.model.QBUser;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Faizul Haque Nayan on 18/10/22.
 */

public class CollectionsUtils {

    public static String makeStringFromUsersFullNames(ArrayList<QBAttachment> allUsers) {
        StringifyArrayList<String> usersNames = new StringifyArrayList<>();

        for (QBAttachment usr : allUsers) {
            if (usr.getName() != null) {
                usersNames.add(usr.getName());
            } else if (usr.getId() != null) {
                usersNames.add(String.valueOf(usr.getId()));
            }
        }
        return usersNames.getItemsAsString().replace(",",", ");
    }

    public static ArrayList<Integer> getIdsSelectedOpponents(Collection<QBAttachment> selectedUsers){
        ArrayList<Integer> opponentsIds = new ArrayList<>();
        if (!selectedUsers.isEmpty()){
            for (QBAttachment qbUser : selectedUsers){
                opponentsIds.add(Integer.parseInt(qbUser.getId()));
            }
        }

        return opponentsIds;
    }
}
