$(document).ready(function() {
    $('#attendance').submit(function(e) {
        e.preventDefault();

        // Clear error messages
        $('#result').html('');
        $('#error-message').html('');

        var utdId = $('#utdId').val();
        var password = $('#password').val();

        // Check if utdId is empty
        if (!utdId) {
            $('#error-message').html('<p>UTD ID cannot be empty</p>');
            return;
        }

        if (utdId.length !== 10) {
            $('#error-message').html('<p>UTD ID must be 10 digits long</p>');
            return;
        }

        if (!password) {
            $('#error-message').html('<p>Password cannot be empty</p>');
            return;
        }


        $.ajax({
            type: 'POST',
            url: 'login.php',
            data: {
                utdId: $('#utdId').val(),
                password: $('#password').val()
            },
            success: function(response) {
                $('#result').html(response);
            },
            error: function() {
                $('#result').html('An error occurred during your request.');
            }
        });
    });
});

/*
// Load quiz from database
$.ajax({
    url: 'get_quiz.php', // URL of the PHP file that interacts with the database
    type: 'GET',
    dataType: 'json',
    success: function(data) {
        // data is the JSON object returned from the server
        // Display the quiz questions
        for (var i = 0; i < data.length; i++) {
            var question = data[i];
            // Display the question and its choices
            // This assumes that each question object has a 'text' property for the question text
            // and a 'choices' property that is an array of choice texts
            $('#quiz').append('<p>' + question.text + '</p>');
            for (var j = 0; j < question.choices.length; j++) {
                var choice = question.choices[j];
                $('#quiz').append('<input type="radio" name="question' + i + '" value="' + choice + '">' + choice + '<br>');
            }
        }
    },
    error: function(jqXHR, textStatus, errorThrown) {
        // Handle any errors
        console.log('Error: ' + textStatus + ' ' + errorThrown);
    }
});
*/