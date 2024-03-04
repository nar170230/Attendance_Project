<?php
/*
    Attendance Webpage Program

    This program connects to a MySQL databasue and is used to login a user into the system.
    It takes in the user's UTD ID and password, and checks if the user exists in the database.
    If the user exists, it returns the user's first name.
    When finished, it closes the connection to the database.

    Written Bryce Ober for CS 4485, started on February 18th, 2024.
    NetID: beo210000
*/

// Set up the database connection, setup for testing purposes
$servername = "localhost";
$dbname = "dbname";
$username = "username";
$password = "password";

// Create connection to database
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

// retrieve the user's UTD ID and password from the POST request
$utdId = $_POST['utdId'];
$password = $_POST['password'];

// Prepare the SQL statement to check if the user exists
$sql = "SELECT * FROM login WHERE utdId = ? AND password = ?";

// Bind the parameters to the SQL statement
$stmt = $conn->prepare($sql);

// Check if the SQL statement was prepared correctly
if ($stmt === false) {
    die("Prepare failed: " . $conn->error);
}
// Bind the parameters to the SQL statement, then execute
$stmt->bind_param("ss", $utdId, $password);
$stmt->execute();

// Get the result of the SQL statement
$result = $stmt->get_result();

// Check if the user exists, if so, return the user's first name
// only for testing purposes since this does not use hashed passwords
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    echo json_encode(['status' => 'success', 'FirstName' => $row['FirstName']]);
} else {
    echo json_encode(['status' => 'failed']);
}

// Close the SQL statement and the database connection
$stmt->close();
$conn->close();

/*
 * this uses password_verify, once database is able to be tested with it, this will be used
if ($result->num_rows > 0) {
    $row = $result->fetch_assoc();
    if (password_verify($password, $row['password'])) {
        echo json_encode(['status' => 'success', 'FirstName' => $row['FirstName']]);
    } else {
        echo json_encode(['status' => 'failed']);
    }
} else {
    echo json_encode(['status' => 'failed']);
}
*/