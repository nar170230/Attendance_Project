<?php

$servername = "localhost";
$dbname = "students";
$username = "bryce";
$password = "123";

// Create connection to database
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$utdId = $_POST['utdId'];
$password = $_POST['password'];

$sql = "SELECT * FROM login WHERE utdId = ? AND password = ?";

$stmt = $conn->prepare($sql);

if ($stmt === false) {
    die("Prepare failed: " . $conn->error);
}

$stmt->bind_param("ss", $utdId, $password);
$stmt->execute();

$result = $stmt->get_result();

// display login status, login successful just for testing purposes
if ($result->num_rows > 0) {
    echo "Login successful";
} else {
    echo "Login failed";
}

$stmt->close();
$conn->close();

/*
<?php

$servername = "localhost";
$dbname = "mysql";
$username = "bryce";
$password = "123";

// Create connection
$conn = new mysqli($servername, $username, $password, $dbname);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}


// This is a simplified example. In a real application, you should use prepared statements to prevent SQL injection.
$utdId = $_POST['utdId'];
$password = $_POST['password'];

// Dummy validation
if ($utdId == 'utdId' && $password == 'password') {
    echo 'Login successful';
} else {
    echo 'Login failed';
}
*/