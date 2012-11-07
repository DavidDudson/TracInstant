/*
 * Copyright 2011 Luke Usherwood.
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
        
package net.bettyluke.tracinstant.prefs;


public class SiteSettings {

    private String url = "";
    private String attachmentsDir = "";
    private boolean fetchOnlyActiveTickets = false;
    private boolean cacheData = true;

    public void setURL(String urlText) {
        url = urlText;
    }

    public void setAttachmentsDir(String attachmentsDirText) {
        attachmentsDir = attachmentsDirText;
    }

    public void setFetchOnlyActiveTickets(boolean b) {
        fetchOnlyActiveTickets = b;
    }
    
    public void setCacheData(boolean b) {
        cacheData = b;
    }

    public String getURL() {
        return url;
    }
    
    public String getAttachmentsDir() {
        return attachmentsDir;
    }
    
    public boolean isFetchOnlyActiveTickets() {
        return fetchOnlyActiveTickets;
    }
    
    public boolean isCacheData() {
        return cacheData;
    }

    public static SiteSettings fromPreferences() {
        SiteSettings ss = new SiteSettings();
        ss.url = TracInstantProperties.getURL();
        ss.attachmentsDir = TracInstantProperties.getAttachmentsDir();
        ss.cacheData = TracInstantProperties.getUseCache();
        ss.fetchOnlyActiveTickets = TracInstantProperties.getActiveTicketsOnly();
        return ss;
    }

    public void updatePreferences() {
        TracInstantProperties.addURL_MRU(getURL());
        TracInstantProperties.addAttachmentsDir_MRU(getAttachmentsDir());
        TracInstantProperties.setUseCache(isCacheData());
        TracInstantProperties.setActiveTicketsOnly(isFetchOnlyActiveTickets());
    }
}