#Creacion de Base de datos
CREATE DATABASE Clinica;
USE Clinica;

#Creacion de tablas (10 tablas)
CREATE TABLE Pacientes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    fecha_nacimiento DATE,
    genero ENUM('M', 'F'),
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

CREATE TABLE Doctores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    especialidad_id INT,
    telefono VARCHAR(20),
    FOREIGN KEY (especialidad_id) REFERENCES Especialidades(id)
);

CREATE TABLE Especialidades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE Citas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    doctor_id INT,
    fecha DATE,
    hora TIME,
    motivo VARCHAR(255),
    FOREIGN KEY (paciente_id) REFERENCES Pacientes(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctores(id)
);

CREATE TABLE Historial_Medico (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    doctor_id INT,
    fecha DATE,
    diagnostico TEXT,
    tratamiento TEXT,
    FOREIGN KEY (paciente_id) REFERENCES Pacientes(id),
    FOREIGN KEY (doctor_id) REFERENCES Doctores(id)
);

CREATE TABLE Medicamentos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10, 2)
);

CREATE TABLE Facturas (
    id INT AUTO_INCREMENT PRIMARY KEY,
    paciente_id INT,
    fecha DATE,
    total DECIMAL(10, 2),
    FOREIGN KEY (paciente_id) REFERENCES Pacientes(id)
);

CREATE TABLE Pagos (
    id INT AUTO_INCREMENT PRIMARY KEY,
    factura_id INT,
    fecha DATE,
    monto DECIMAL(10, 2),
    metodo_pago ENUM('Efectivo', 'Tarjeta', 'Transferencia'),
    FOREIGN KEY (factura_id) REFERENCES Facturas(id)
);

CREATE TABLE Empleados (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    puesto VARCHAR(100),
    telefono VARCHAR(20),
    salario DECIMAL(10, 2)
);

CREATE TABLE Horarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    empleado_id INT,
    dia ENUM('Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo'),
    hora_entrada TIME,
    hora_salida TIME,
    FOREIGN KEY (empleado_id) REFERENCES Empleados(id)
);

#Insercion de datos
INSERT INTO Pacientes (nombre, apellido, fecha_nacimiento, genero, direccion, telefono) VALUES
('Juan', 'Perez', '1980-01-01', 'M', 'Calle 1', '1234567890'),
('Maria', 'Lopez', '1985-02-15', 'F', 'Calle 2', '0987654321'),
('Carlos', 'Martinez', '1990-03-20', 'M', 'Calle 3', '1122334455'),
('Ana', 'Gonzalez', '1975-04-25', 'F', 'Calle 4', '2233445566'),
('Luis', 'Rodriguez', '1988-05-30', 'M', 'Calle 5', '3344556677'),
('Laura', 'Garcia', '1992-06-05', 'F', 'Calle 6', '4455667788'),
('Jose', 'Martinez', '1983-07-10', 'M', 'Calle 7', '5566778899'),
('Lucia', 'Hernandez', '1995-08-15', 'F', 'Calle 8', '6677889900'),
('Miguel', 'Fernandez', '1978-09-20', 'M', 'Calle 9', '7788990011'),
('Sofia', 'Diaz', '1982-10-25', 'F', 'Calle 10', '8899001122'),
('Daniel', 'Torres', '1989-11-30', 'M', 'Calle 11', '9900112233'),
('Sara', 'Sanchez', '1993-12-05', 'F', 'Calle 12', '1011121314'),
('Jorge', 'Ramirez', '1987-01-10', 'M', 'Calle 13', '1213141516'),
('Isabel', 'Flores', '1991-02-15', 'F', 'Calle 14', '1314151617'),
('Pablo', 'Vazquez', '1984-03-20', 'M', 'Calle 15', '1415161718');

INSERT INTO Doctores (nombre, apellido, especialidad_id, telefono) VALUES
('Dr. Pablo', 'Perez', 1, '1234567890'),
('Dr. Maria', 'Gonzalez', 2, '0987654321'),
('Dr. Nataly', 'Martinez', 3, '1122334455'),
('Dr. Ana', 'Lopez', 4, '2233445566'),
('Dr. Luis', 'Rivas', 1, '3344556677'),
('Dr. Laura', 'Nolasco', 2, '4455667788'),
('Dr. Jose', 'Buenavista', 3, '5566778899'),
('Dr. Sarai', 'Hernandez', 4, '6677889900'),
('Dr. Angel', 'Fernandez', 1, '7788990011'),
('Dr. Sofia', 'Bermudez', 2, '8899001122'),
('Dr. Daniel', 'Del Cid', 3, '9900112233'),
('Dr. Kimberly', 'Sanchez', 4, '1011121314'),
('Dr. Milton', 'Ramirez', 1, '1213141516'),
('Dr. Isabel', 'Vasquez', 2, '1314151617'),
('Dr. Juan', 'Escobar', 3, '1415161718');

INSERT INTO Especialidades (nombre) VALUES
('Cardiología'),
('Dermatología'),
('Neurología'),
('Pediatría'),
('Ginecología'),
('Urología'),
('Endocrinología'),
('Gastroenterología'),
('Oftalmología'),
('Otorrinolaringología'),
('Neumología'),
('Psiquiatría'),
('Reumatología'),
('Oncología'),
('Nefrología');

INSERT INTO Citas (paciente_id, doctor_id, fecha, hora, motivo) VALUES
(1, 16, '2023-01-01', '10:00:00', 'Consulta general'),
(2, 17, '2023-01-02', '11:00:00', 'Consulta dermatológica'),
(3, 18, '2023-01-03', '12:00:00', 'Consulta neurológica'),
(4, 19, '2023-01-04', '13:00:00', 'Consulta pediátrica'),
(5, 20, '2023-01-05', '14:00:00', 'Consulta cardiológica'),
(6, 21, '2023-01-06', '15:00:00', 'Consulta ginecológica'),
(7, 22, '2023-01-07', '16:00:00', 'Consulta urológica'),
(8, 23, '2023-01-08', '17:00:00', 'Consulta endocrinológica'),
(9, 24, '2023-01-09', '18:00:00', 'Consulta gastroenterológica'),
(10, 25, '2023-01-10', '19:00:00', 'Consulta oftalmológica'),
(11, 26, '2023-01-11', '20:00:00', 'Consulta otorrinolaringológica'),
(12, 27, '2023-01-12', '21:00:00', 'Consulta neumológica'),
(13, 28, '2023-01-13', '22:00:00', 'Consulta psiquiátrica'),
(14, 29, '2023-01-14', '23:00:00', 'Consulta reumatológica'),
(15, 30, '2023-01-15', '09:00:00', 'Consulta oncológica');

INSERT INTO Historial_Medico (paciente_id, doctor_id, fecha, diagnostico, tratamiento) VALUES
(1, 30, '2023-01-01', 'Diagnóstico 1', 'Tratamiento 1'),
(2, 16, '2023-01-02', 'Diagnóstico 2', 'Tratamiento 2'),
(3, 17, '2023-01-03', 'Diagnóstico 3', 'Tratamiento 3'),
(4, 18, '2023-01-04', 'Diagnóstico 4', 'Tratamiento 4'),
(5, 19, '2023-01-05', 'Diagnóstico 5', 'Tratamiento 5'),
(6, 20, '2023-01-06', 'Diagnóstico 6', 'Tratamiento 6'),
(7, 21, '2023-01-07', 'Diagnóstico 7', 'Tratamiento 7'),
(8, 22, '2023-01-08', 'Diagnóstico 8', 'Tratamiento 8'),
(9, 23, '2023-01-09', 'Diagnóstico 9', 'Tratamiento 9'),
(10, 24, '2023-01-10', 'Diagnóstico 10', 'Tratamiento 10'),
(11, 25, '2023-01-11', 'Diagnóstico 11', 'Tratamiento 11'),
(12, 26, '2023-01-12', 'Diagnóstico 12', 'Tratamiento 12'),
(13, 27, '2023-01-13', 'Diagnóstico 13', 'Tratamiento 13'),
(14, 28, '2023-01-14', 'Diagnóstico 14', 'Tratamiento 14'),
(15, 29, '2023-01-15', 'Diagnóstico 15', 'Tratamiento 15');

INSERT INTO Medicamentos (nombre, descripcion, precio) VALUES
('Medicamento 1', 'Descripción del Medicamento 1', 10.00),
('Medicamento 2', 'Descripción del Medicamento 2', 15.00),
('Medicamento 3', 'Descripción del Medicamento 3', 20.00),
('Medicamento 4', 'Descripción del Medicamento 4', 25.00),
('Medicamento 5', 'Descripción del Medicamento 5', 30.00),
('Medicamento 6', 'Descripción del Medicamento 6', 35.00),
('Medicamento 7', 'Descripción del Medicamento 7', 40.00),
('Medicamento 8', 'Descripción del Medicamento 8', 45.00),
('Medicamento 9', 'Descripción del Medicamento 9', 50.00),
('Medicamento 10', 'Descripción del Medicamento 10', 55.00),
('Medicamento 11', 'Descripción del Medicamento 11', 60.00),
('Medicamento 12', 'Descripción del Medicamento 12', 65.00),
('Medicamento 13', 'Descripción del Medicamento 13', 70.00),
('Medicamento 14', 'Descripción del Medicamento 14', 75.00),
('Medicamento 15', 'Descripción del Medicamento 15', 80.00);

INSERT INTO Facturas (paciente_id, fecha, total) VALUES
(1, '2023-01-01', 100.00),
(2, '2023-01-02', 150.00),
(3, '2023-01-03', 200.00),
(4, '2023-01-04', 250.00),
(5, '2023-01-05', 300.00),
(6, '2023-01-06', 350.00),
(7, '2023-01-07', 400.00),
(8, '2023-01-08', 450.00),
(9, '2023-01-09', 500.00),
(10, '2023-01-10', 550.00),
(11, '2023-01-11', 600.00),
(12, '2023-01-12', 650.00),
(13, '2023-01-13', 700.00),
(14, '2023-01-14', 750.00),
(15, '2023-01-15', 800.00);

INSERT INTO Pagos (factura_id, fecha, monto, metodo_pago) VALUES
(1, '2023-01-01', 100.00, 'Efectivo'),
(2, '2023-01-02', 150.00, 'Tarjeta'),
(3, '2023-01-03', 200.00, 'Transferencia'),
(4, '2023-01-04', 250.00, 'Efectivo'),
(5, '2023-01-05', 300.00, 'Tarjeta'),
(6, '2023-01-06', 350.00, 'Transferencia'),
(7, '2023-01-07', 400.00, 'Efectivo'),
(8, '2023-01-08', 450.00, 'Tarjeta'),
(9, '2023-01-09', 500.00, 'Transferencia'),
(10, '2023-01-10', 550.00, 'Efectivo'),
(11, '2023-01-11', 600.00, 'Tarjeta'),
(12, '2023-01-12', 650.00, 'Transferencia'),
(13, '2023-01-13', 700.00, 'Efectivo'),
(14, '2023-01-14', 750.00, 'Tarjeta'),
(15, '2023-01-15', 800.00, 'Transferencia');

INSERT INTO Empleados (nombre, apellido, puesto, telefono, salario) VALUES
('Maria', 'Melara', 'Recepcionista', '1234567890', 1000.00),
('Juan', 'Amaya', 'Enfermero', '0987654321', 1500.00),
('Julio', 'Bernal', 'Técnico', '1122334455', 2000.00),
('Stephany', 'Campos', 'Administradora', '2233445566', 2500.00),
('Gabriela', 'Salvador', 'Limpieza', '3344556677', 1200.00),
('Benjamin', 'Rivera', 'Secretario', '4455667788', 1300.00),
('Jose', 'Hernandez', 'Enfermero', '5566778899', 1500.00),
('Karen', 'Murillo', 'Recepcionista', '6677889900', 1000.00),
('Esmeralda', 'Colorado', 'Técnico', '7788990011', 2000.00),
('Samuel', 'Rojas', 'Administrador', '8899001122', 2500.00),
('Sergio', 'Guevara', 'Limpieza', '9900112233', 1200.00),
('Cristina', 'Martinez', 'Secretaria', '1011121314', 1300.00),
('Carlos', 'Hernandez', 'Enfermero', '1213141516', 1500.00),
('Miguel', 'Arevalo', 'Recepcionista', '1314151617', 1000.00),
('Ronald', 'Gutierrez', 'Técnico', '1415161718', 2000.00);

INSERT INTO Horarios (empleado_id, dia, hora_entrada, hora_salida) VALUES
(1, 'Lunes', '08:00:00', '17:00:00'),
(2, 'Martes', '08:00:00', '17:00:00'),
(3, 'Miércoles', '08:00:00', '17:00:00'),
(4, 'Jueves', '08:00:00', '17:00:00'),
(5, 'Viernes', '08:00:00', '17:00:00'),
(6, 'Sábado', '08:00:00', '12:00:00'),
(7, 'Lunes', '08:00:00', '17:00:00'),
(8, 'Martes', '08:00:00', '17:00:00'),
(9, 'Miércoles', '08:00:00', '17:00:00'),
(10, 'Jueves', '08:00:00', '17:00:00'),
(11, 'Viernes', '08:00:00', '17:00:00'),
(12, 'Sábado', '08:00:00', '12:00:00'),
(13, 'Lunes', '08:00:00', '17:00:00'),
(14, 'Martes', '08:00:00', '17:00:00'),
(15, 'Miércoles', '08:00:00', '17:00:00');

SELECT * FROM Doctores;
select * from Pacientes;





