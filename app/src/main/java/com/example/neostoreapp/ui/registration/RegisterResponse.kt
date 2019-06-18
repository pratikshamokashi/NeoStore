package com.example.neostoreapp.ui.registration

import com.example.neostoreapp.ui.login.Data

class RegisterResponse(
    var status:Int=0,
    var message:String="",
    var user_msg:String="",
    var data: Data
)
class Data() {
    var id: Int = 0
    var role_id: Int = 0
    var first_name: String = ""
    var last_name: String = ""
    var email: String = ""
    var username: String = ""
    var country_id: Int = 0
    var gender: String = ""
    var phone_no: String = ""
    var dob: String = ""
    var is_active: Boolean = true
}