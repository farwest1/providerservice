package com.moeller.rest.dto;

/**
 * Created by Bernd on 25.08.2016.
 *
 *  This is the DTO for Permmisions
 */
public class Permission {
    private long permissionId;
    private String permissionName;

    public Permission(){};
    public Permission(long permissionId, String permissionName){
        this.permissionId = permissionId;
        this.permissionName = permissionName;
    }

    public long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }
}
