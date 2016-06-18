package com.example.shubham.assignment_dipper;

import java.util.List;

/**
 * Created by shubham on 6/4/16.
 */
public class Data {
    private int id;
    private int shipper_id;
    private int trucker_id;
    private String route_start;
    private String route_end;
    private int booking_price;
    private int booked_quantity;
    private String status;
    private boolean pending_trucker_confirmation;
    private boolean pending_shipper_confirmation;
    private int load_id;
    private int total_amount;
    private String truck_type;
    private int trucker_request_id;
    private boolean read;
    private int consigner_id;
    private String pickup_address;
    private String drop_address;
    private String created_at;
    private String updated_at;
    private Shipper shipper;
    private Trucker trucker;

    public Shipper getShipper() {
        return shipper;
    }

    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    public Trucker getTrucker() {
        return trucker;
    }

    public void setTrucker(Trucker trucker) {
        this.trucker = trucker;
    }

    public Load getLoad() {
        return load;
    }

    public void setLoad(Load load) {
        this.load = load;
    }

    public Trucker_Request getTrucker_request() {
        return trucker_request;
    }

    public void setTrucker_request(Trucker_Request trucker_request) {
        this.trucker_request = trucker_request;
    }

    public List<Trucks> getTrucks() {
        return trucks;
    }

    public void setTrucks(List<Trucks> trucks) {
        this.trucks = trucks;
    }

    private Load load;
    private Trucker_Request trucker_request;
    private List<Trucks> trucks;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public int getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(int trucker_id) {
        this.trucker_id = trucker_id;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public int getBooking_price() {
        return booking_price;
    }

    public void setBooking_price(int booking_price) {
        this.booking_price = booking_price;
    }

    public int getBooked_quantity() {
        return booked_quantity;
    }

    public void setBooked_quantity(int booked_quantity) {
        this.booked_quantity = booked_quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPending_trucker_confirmation() {
        return pending_trucker_confirmation;
    }

    public void setPending_trucker_confirmation(boolean pending_trucker_confirmation) {
        this.pending_trucker_confirmation = pending_trucker_confirmation;
    }

    public boolean isPending_shipper_confirmation() {
        return pending_shipper_confirmation;
    }

    public void setPending_shipper_confirmation(boolean pending_shipper_confirmation) {
        this.pending_shipper_confirmation = pending_shipper_confirmation;
    }

    public int getLoad_id() {
        return load_id;
    }

    public void setLoad_id(int load_id) {
        this.load_id = load_id;
    }

    public int getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(int total_amount) {
        this.total_amount = total_amount;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTrucker_request_id() {
        return trucker_request_id;
    }

    public void setTrucker_request_id(int trucker_request_id) {
        this.trucker_request_id = trucker_request_id;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public int getConsigner_id() {
        return consigner_id;
    }

    public void setConsigner_id(int consigner_id) {
        this.consigner_id = consigner_id;
    }

    public String getPickup_address() {
        return pickup_address;
    }

    public void setPickup_address(String pickup_address) {
        this.pickup_address = pickup_address;
    }

    public String getDrop_address() {
        return drop_address;
    }

    public void setDrop_address(String drop_address) {
        this.drop_address = drop_address;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
class Shipper{

    private  int id;
    private  boolean is_verified;
    private String company_name;
    private String office_phone_no;
    private String state;
    private String city;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean is_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getOffice_phone_no() {
        return office_phone_no;
    }

    public void setOffice_phone_no(String office_phone_no) {
        this.office_phone_no = office_phone_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

}
class  Trucker{
    private int id;
    private boolean is_verified;
    private String trucker_name;
    private String company_name;
    private String pan_no;
    private String office_phone_no;
    private String state;
    private String city;
    private int fleet_size;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean is_verified() {
        return is_verified;
    }

    public void setIs_verified(boolean is_verified) {
        this.is_verified = is_verified;
    }

    public String getTrucker_name() {
        return trucker_name;
    }

    public void setTrucker_name(String trucker_name) {
        this.trucker_name = trucker_name;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getPan_no() {
        return pan_no;
    }

    public void setPan_no(String pan_no) {
        this.pan_no = pan_no;
    }

    public String getOffice_phone_no() {
        return office_phone_no;
    }

    public void setOffice_phone_no(String office_phone_no) {
        this.office_phone_no = office_phone_no;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getFleet_size() {
        return fleet_size;
    }

    public void setFleet_size(int fleet_size) {
        this.fleet_size = fleet_size;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
class Load{
    private int id;
    private int shipper_id;
    private String route_start;
    private String route_end;
    private int tonnage;
    private String truck_type;
    private int truck_no_reqd;
    private boolean is_active;
    private String load_state;
    private int quoted_price;
    private String pickup_date;
    private String material_type;
    private boolean read;
    private String created_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getShipper_id() {
        return shipper_id;
    }

    public void setShipper_id(int shipper_id) {
        this.shipper_id = shipper_id;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTruck_no_reqd() {
        return truck_no_reqd;
    }

    public void setTruck_no_reqd(int truck_no_reqd) {
        this.truck_no_reqd = truck_no_reqd;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getLoad_state() {
        return load_state;
    }

    public void setLoad_state(String load_state) {
        this.load_state = load_state;
    }

    public int getQuoted_price() {
        return quoted_price;
    }

    public void setQuoted_price(int quoted_price) {
        this.quoted_price = quoted_price;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getMaterial_type() {
        return material_type;
    }

    public void setMaterial_type(String material_type) {
        this.material_type = material_type;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    private String updated_at;
}
class Trucker_Request{
    private int id;
    private int request_id;
    private String route_start;
    private String route_end;
    private int tonnage;
    private int trucks_no_available;
    private boolean is_active;
    private int quoted_price;
    private String truck_type;
    private int trucker_id;
    private String request_state;
    private boolean read;
    private String pickup_date;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public int getTrucks_no_available() {
        return trucks_no_available;
    }

    public void setTrucks_no_available(int trucks_no_available) {
        this.trucks_no_available = trucks_no_available;
    }

    public boolean is_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public int getQuoted_price() {
        return quoted_price;
    }

    public void setQuoted_price(int quoted_price) {
        this.quoted_price = quoted_price;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(int trucker_id) {
        this.trucker_id = trucker_id;
    }

    public String getRequest_state() {
        return request_state;
    }

    public void setRequest_state(String request_state) {
        this.request_state = request_state;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }

    public String getPickup_date() {
        return pickup_date;
    }

    public void setPickup_date(String pickup_date) {
        this.pickup_date = pickup_date;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public boolean isCheck_near_location() {
        return check_near_location;
    }

    public void setCheck_near_location(boolean check_near_location) {
        this.check_near_location = check_near_location;
    }

    public boolean isCheck_near_location_route_end() {
        return check_near_location_route_end;
    }

    public void setCheck_near_location_route_end(boolean check_near_location_route_end) {
        this.check_near_location_route_end = check_near_location_route_end;
    }

    private boolean check_near_location;
    private boolean check_near_location_route_end;
}
class Trucks{
    private int id;
    private int driver_id;
    private String truck_number;
    private String truck_company;
    private String truck_type;
    private int tonnage;
    private String truck_year;
    private String route_start;
    private String route_end;
    private String status;
    private int trucker_id;
    private String chassis_no;
    private String created_at;
    private String updated_at;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getTruck_number() {
        return truck_number;
    }

    public void setTruck_number(String truck_number) {
        this.truck_number = truck_number;
    }

    public String getTruck_company() {
        return truck_company;
    }

    public void setTruck_company(String truck_company) {
        this.truck_company = truck_company;
    }

    public String getTruck_type() {
        return truck_type;
    }

    public void setTruck_type(String truck_type) {
        this.truck_type = truck_type;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }

    public String getTruck_year() {
        return truck_year;
    }

    public void setTruck_year(String truck_year) {
        this.truck_year = truck_year;
    }

    public String getRoute_start() {
        return route_start;
    }

    public void setRoute_start(String route_start) {
        this.route_start = route_start;
    }

    public String getRoute_end() {
        return route_end;
    }

    public void setRoute_end(String route_end) {
        this.route_end = route_end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTrucker_id() {
        return trucker_id;
    }

    public void setTrucker_id(int trucker_id) {
        this.trucker_id = trucker_id;
    }

    public String getChassis_no() {
        return chassis_no;
    }

    public void setChassis_no(String chassis_no) {
        this.chassis_no = chassis_no;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
