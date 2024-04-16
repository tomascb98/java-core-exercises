package com.epam.rd.contactbook;

public class Contact {
    private String name;
    private ContactInfo phoneNumber;
    private ContactInfo[] emails;
    private int countEmail = 0;
    private ContactInfo[] linksSocialMedia;
    private int countMedia = 0;



    public Contact(String contactName) {
        this.name = contactName;
        this.emails = new ContactInfo[3];
        this.linksSocialMedia = new ContactInfo[5];
    }

    private class NameContactInfo implements ContactInfo{
        @Override
        public String getTitle() {
            return "Name";
        }
        @Override
        public String getValue() {
            return name;
        }
    }

    public static class Email implements ContactInfo{
        private String email;

        public Email(String email) {
            this.email = email;
        }

        @Override
        public String getTitle() {
            return "Email";
        }
        @Override
        public String getValue() {
            return email;
        }
    }

    public static class Social implements ContactInfo{
        private String title;
        private String socialMediaLink;
        private static int count = 0;

        public Social(String title, String socialMediaLink) {
            this.title = title;
            this.socialMediaLink = socialMediaLink;
        }

        @Override
        public String getTitle() {
            return title;
        }

        @Override
        public String getValue() {
            return socialMediaLink;
        }
    }

    public void rename(String newName) {
        if(newName != null && !newName.equals("")) name = newName;
    }

    public Email addEmail(String localPart, String domain) {
        Email emailToAdd = new Email(localPart + "@" + domain);
        if(countEmail < 3) {
            emails[countEmail] = emailToAdd;
            countEmail++;
            return emailToAdd;
        }
        return null;
    }


    public Email addEpamEmail(String firstname, String lastname) {
        Email emailToAdd = new Email(firstname + "_" + lastname + "@epam.com") {
            @Override
            public String getTitle() {
                return "Epam Email";
            }
        };
        if(countEmail < 3) {
            emails[countEmail] = emailToAdd;
            countEmail++;
            return emailToAdd;
        }
        return null;
    }

    public ContactInfo addPhoneNumber(int code, String number) {
        if(phoneNumber == null) {
            phoneNumber = new ContactInfo() {
                @Override
                public String getTitle() {
                    return "Tel";
                }

                @Override
                public String getValue() {
                    return "+" + code + " " + number;
                }
            };
            return phoneNumber;
        }
        return null;
    }

    public Social addTwitter(String twitterId) {
        Social mediaToAdd = new Social("Twitter", twitterId);
        if(countMedia < 5) {
            linksSocialMedia[countMedia] = mediaToAdd;
            countMedia++;
            return mediaToAdd;
        }
        return null;
    }

    public Social addInstagram(String instagramId) {
        Social mediaToAdd = new Social("Instagram", instagramId);
        if(countMedia < 5) {
            linksSocialMedia[countMedia] = mediaToAdd;
            countMedia++;
            return mediaToAdd;
        }
        return null;
    }

    public Social addSocialMedia(String title, String id) {
        Social mediaToAdd = new Social(title, id);
        if(countMedia < 5) {
            linksSocialMedia[countMedia] = mediaToAdd;
            countMedia++;
            return mediaToAdd;
        }
        return null;
    }

    public ContactInfo[] getInfo() {
        int countName = 0;
        int countPhone = 0;
        int countEmail = 0;
        int countMedia = 0;
        if(name != null){
            countName++;
        }
        if( phoneNumber != null){
            countPhone++;
        }
        for (ContactInfo email: emails) {
            if(email != null){
                countEmail++;
            }
        }
        for (ContactInfo media: linksSocialMedia) {
            if(media != null){
                countMedia++;
            }
        }

        ContactInfo[] contactInfos = new ContactInfo[countEmail+countMedia+countName+countPhone];

        int positionToAdd=0;

        if(countName==1){
            contactInfos[positionToAdd] = new NameContactInfo();
            positionToAdd++;
        }
        if(countPhone==1){
            contactInfos[positionToAdd] = phoneNumber;
            positionToAdd++;
        }
        for(int i = 0 ; i<countEmail; i++){
            contactInfos[positionToAdd] = emails[i];
            positionToAdd++;
            }
        for(int i = 0 ; i<countMedia; i++){
            contactInfos[positionToAdd] = linksSocialMedia[i];
            positionToAdd++;
        }

        return contactInfos;
        }

}




