# monitor
A TCP monitor

## db AUTH
Create a file called `db-auth.php` with the following contents:

```php
<?php
define('SQL_USER','<dbuser>');
define('SQL_SERVER','<db_server>');
define('SQL_PASS','<pass>');
define('SQL_DB','<database>');
define('SQL_PORT',3306);
?>
