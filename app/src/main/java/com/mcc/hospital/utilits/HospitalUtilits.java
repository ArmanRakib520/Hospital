package com.mcc.hospital.utilits;

import com.mcc.hospital.model.Hospitalname;

import java.util.ArrayList;

public class HospitalUtilits {

    public static ArrayList<Hospitalname> getHospitalList(ArrayList<Hospitalname> hospitalnameArrayList, int categorId) {
        ArrayList<Hospitalname> allChannelList = new ArrayList<>();
        for (int j = 0; j < hospitalnameArrayList.size(); j++) {
            Hospitalname hospitalname = hospitalnameArrayList.get(j);
            int category_id = hospitalname.getCategoryId();
            if (category_id == categorId) {
                int hospital_id = hospitalname.getHospitalId();
                String hospital_name = hospitalname.getHospitalName();
                String hospital_address = hospitalname.getHospitalAddress();
                int hospital_contuct = hospitalname.getHospitalContuct();
                String hospital_logo_url = hospitalname.getHospitalLogoUrl();
                Hospitalname single_channel = new Hospitalname(hospital_id, category_id, hospital_name, hospital_address, hospital_contuct, hospital_logo_url);
                allChannelList.add(single_channel);
            } else if (categorId == AppConstant.All_CATEGORY) {
                int hospital_id = hospitalname.getHospitalId();
                String hospital_name = hospitalname.getHospitalName();
                String hospital_address = hospitalname.getHospitalAddress();
                int hospital_contuct = hospitalname.getHospitalContuct();
                String hospital_logo_url = hospitalname.getHospitalLogoUrl();
                Hospitalname hospitalnamee = new Hospitalname(hospital_id, category_id, hospital_name, hospital_address, hospital_contuct, hospital_logo_url);
                allChannelList.add(hospitalnamee);
            }

        }

        return allChannelList;
    }

}
