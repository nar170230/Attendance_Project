/*
    Attendance Webpage Program

    Facilitates student login for attendance tracking and quiz participation. Upon successful login,
    students' attendance is registered, and any available quizzes are displayed. This script manages the login
    process by validating UTD ID and password against server records.

    Written Bryce Ober for CS 4485, started on February 18th, 2024.
    NetID: beo210000
*/

// Handles form submission for attendance tracking. Validates input before making a server request.
$(document).ready(function() {
    $('#attendance').submit(function(e) {
        e.preventDefault(); // Prevent default submission behavior

        // Clears previous messages, to clean up the form
        $('#result, #error-message').html('');

        // Retrieves user input, from the form
        var utdId = $('#utdId').val();
        var password = $('#password').val();

        // Input validation for UTD ID and password
        // if utdId is empty, prompt user to enter UTD ID
        if (!utdId) {
            $('#error-message').html('<p>UTD ID cannot be empty.</p>');
            return;
        }
        // if utdId is not 10 digits long, prompt user to enter 10 digit UTD ID
        if (utdId.length !== 10) {
            $('#error-message').html('<p>UTD ID must be 10 digits long.</p>');
            return;
        }
        // if password is empty, prompt user to enter password
        if (!password) {
            $('#error-message').html('<p>Password cannot be empty.</p>');
            return;
        }

        // AJAX request to server for login validation
        $.ajax({
            type: 'POST',
            url: 'login.php', // URL of the PHP file that interacts with the database
            data: { utdId, password },
            success: function(response) {
                var data = JSON.parse(response);
                if (data.status === 'success') {
                    // Success: Hides form and displays attendance confirmation, for the date
                    $('#attendance, #error-message').hide();
                    $('#success-message').html(`${data.FirstName}, your attendance has been noted for 
                    ${new Date().toLocaleDateString()}.`);
                } else {
                    // Failure: Shows login failure message
                    $('#result').html('Login failed.');
                }
            },
            error: function() {
                // Handles request error
                $('#result').html('An error occurred during your request.');
            }
        });
    });
});