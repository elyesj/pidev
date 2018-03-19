/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidev.entities;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DateTimeDV;

/**
 *
 * @author MBM info
 */
public class notification {
 public int id;
 public String message;
 public String link;
 public boolean isRead;
 public DateTimeDV addedAt;

    public notification() {
    }

    public notification(int id, String message, String link, boolean isRead, DateTimeDV addedAt, int user_id) {
        this.id = id;
        this.message = message;
        this.link = link;
        this.isRead = isRead;
        this.addedAt = addedAt;
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "notification{" + "id=" + id + ", message=" + message + ", link=" + link + ", isRead=" + isRead + ", addedAt=" + addedAt + ", user_id=" + user_id + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    public DateTimeDV getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(DateTimeDV addedAt) {
        this.addedAt = addedAt;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
 public int user_id;
    
}
