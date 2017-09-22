/**
 * Created by terzi on 22.6.2017..
 */
$(document).ready(function () {

    $('#upisniList').submit(function (e) {
        e.preventDefault();
        var faculty = $("input[name='faculty']").val().toString();
        var indexNumber = $("input[name='indexNumber']").val();
        var studentFullName = $("input[name='studentFirstName']").val() + " " + $("input[name='parentName']").val() + " "
            + $("input[name='studentLastName']").val();
        var studentType = $("input[name='studentType']").val();
        var semester = $("input[name='semester']").val();
        var studyCycle = $("input[name='studyCycle']").val();
        var department = $("input[name='department']").val();
        var jmbg = $("input[name='jmbg']").val();
        var dob = $("input[name='dob']").val();
        var citizenship = $("input[name='citizenship']").val();
        var nationality = $("input[name='nationality']").val();
        var highSchool = $("input[name='highSchool']").val();
        var father = $("input[name='father']").val();
        var mother = $("input[name='mother']").val();
        var fatherOccupation = $("input[name='fatherOccupation']").val();
        var motherOccupation = $("input[name='motherOccupation']").val();
        var currentAddress = $("input[name='currentAddress']").val().toString();
        var telNumber = $("input[name='telNumber']").val();
        var email = $("input[name='eMail']").val();
        var placeOfBirth = $("input[name='placeOfBirth']").val();

        var upisniPodaci = {
            "faculty": faculty,
            "indexNumber": indexNumber,
            "studentFullName": studentFullName,
            "studentType": studentType,
            "semester": semester,
            "studyCycle": studyCycle,
            "department": department,
            "jmbg": jmbg,
            "dob": dob,
            "citizenship": citizenship,
            "nationality": nationality,
            "highSchool": highSchool,
            "father": father,
            "mother": mother,
            "fatherOccupation": fatherOccupation,
            "motherOccupation": motherOccupation,
            "currentAddress": currentAddress,
            "telNumber": telNumber,
            "eMail": email,
            "placeOfBirth": placeOfBirth,
            "place": "some place",//TODO ovog nema u formi
            "country": "BiH",//TODO ovog nema u formi
            "date": "22.12.2313",//TODO ovog nema u formi
            "canton": "dfsfs"//TODO ovog nema u formi

        };
        console.log(JSON.stringify(upisniPodaci));
        $.ajax({
            type: 'POST',
            url: '/entrypapers/signupform',
            dataType: 'json',
            contentType: 'application/json; charset=UTF-8',
            data: JSON.stringify(upisniPodaci)

        }).done(function (status) {
            //alert("ok " + status.toString());
            window.open(status.certificate);
        }).fail(function (status) {
            console.log("error " + status.toString());
        });

    });


    /*(function ($) {
        $.fn.serializeFormJSON = function () {

            var o = {};
            var a = this.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        };
    })(jQuery);

    $('#prijavniList').submit(function (e) {
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        console.log(data);


    });

    $('#upisniList').submit(function (e) {
        e.preventDefault();
        var data = $(this).serializeFormJSON();
        console.log(data);


    });*/

});


