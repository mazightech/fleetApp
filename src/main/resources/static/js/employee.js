$('document').ready(function () {

    //Edit employee
    $('.table #editButton').on('click', function (event) {
        event.preventDefault();
        //Get employee elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (employee, status) {
            $('#address-edit').val(employee.address);
            $('#city-edit').val(employee.city);
            $('#ddlCountryEdit').val(employee.countryid);
            if(employee.dateOfBirth != null)
            var dob = employee.dateOfBirth.substr(0,10);
            $('#dateOfBirth-edit').val(dob);
            $('#email-edit').val(employee.email);
            $('#firstname-edit').val(employee.firstname);
            $('#gender-edit').val(employee.gender);
            $('#id-edit').val(employee.id);
            $('#initials-edit').val(employee.initials);
            $('#lastname-edit').val(employee.lastname);
            $('#ddlMaritalStatusEdit').val(employee.matrialStatus);
            $('#mobile-edit').val(employee.mobile);
            $('#othername-edit').val(employee.othername);
            $('#phone-edit').val(employee.phone);
            $('#photo-edit').val(employee.photo);
            $('#SSN-edit').val(employee.socialSecurityNumber);
            $('#ddlStateEdit').val(employee.stateid);
            $('#title-edit').val(employee.title);
            $('#ddlEmployeeTypeEdit').val(employee.employeetypeid);
            if(employee.hireDate != null)
            var hireDate = employee.hireDate.substr(0,10);
            $('#hireDate-edit').val(hireDate);
            $('#ddlJobTitleEdit').val(employee.jobtitleid);
        });
        // show edit modal
        $('#editModal').modal();
    });

    //Details employee
    $('.table #detailsButton').on('click', function (event) {
        event.preventDefault();
        //Get employee elements to be modified
        var href = $(this).attr('href');
        $.get(href, function (employee, status) {
            $('#address-detail').val(employee.address);
            $('#city-detail').val(employee.city);
            $('#ddlCountryDetail').val(employee.countryid);
            var dob = employee.dateOfBirth.substr(0,10);
            $('#dateOfBirth-detail').val(dob);
            $('#email-detail').val(employee.email);
            $('#firstname-detail').val(employee.firstname);
            $('#gender-detail').val(employee.gender);
            $('#initials-detail').val(employee.initials);
            $('#lastname-detail').val(employee.lastname);
            $('#ddlMaritalStatusDetail').val(employee.matrialStatus);
            $('#mobile-detail').val(employee.mobile);
            $('#othername-detail').val(employee.othername);
            $('#phone-detail').val(employee.phone);
            $('#SSN-detail').val(employee.socialSecurityNumber);
            $('#ddlStateDetail').val(employee.stateid);
            $('#title-detail').val(employee.title);
            $('#ddlEmployeeTypeDetail').val(employee.employeetypeid);
            var hireDate = employee.hireDate.substr(0,10);
            $('#hireDate-detail').val(hireDate);
            $('#ddlJobTitleDetail').val(employee.jobtitleid);
            $('#lastModifiedBy-details').val(employee.lastModifiedBy);
            $('#lastModifiedDate-details').val(employee.lastModifiedDate.substr(0,19).replace("T"," "));
        });
        // show edit modal
        $('#detailModal').modal();
    });

    // delete
    $('.table #deleteButton').on('click', function (event) {
        event.preventDefault();

        // passer delete link from  href html to href of modal
        var href = $(this).attr('href');
        $('#confirmdelete').attr('href', href);
        //show delete pop modal
        $('#deleteModal').modal();
    });

    // show image
    $('.table #photoButton').on('click', function (event) {
        event.preventDefault();

        // Passer l'url de l'image de la table vers le modal
        var href = $(this).attr('href');
        $('#photoModal #employeePhoto').attr('href',href);

        $('#photoModal').modal();

    })

});