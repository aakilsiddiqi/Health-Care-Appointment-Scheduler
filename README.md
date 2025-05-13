# Health-Care-Appointment-Scheduler
Description: As a visitor, I want to see a list of available doctors and their time slot to choose from.

Acceptance Criteria:

Set available time slots for individual Doctor for appointment. Scheduling should be only between 10:00 AM to 8:00 PM. Set this data in the repository or DAO layer
Each doctor entry should include Id, name, specialization, and available slots •
Display the list of all available doctors

User Stories:
US 01: View Available Doctors

Description: As a visitor, I want to see a list of available doctors and their time slot to choose from.

Acceptance Criteria:

Set available time slots for individual Doctor for appointment. Scheduling should be only between 10:00 AM to 8:00 PM. Set this data in the repository or DAO layer
Each doctor entry should include Id, name, specialization, and available slots •
Display the list of all available doctors

US 02: Search Doctors

Description: As a patient , I want to search for doctors by providing the specialization.

Acceptance Criteria:

The patient should be able to search the doctors by their specialization
Search results should show doctors information in ascending order based on the available date
If the search criteria are incorrect handle the exception with appropriate error message

US 03: Book Appointment

Description: As a patient, I should be able to book an appointment with a doctor.

Acceptance Criteria:

Patients should be able to select a doctor and choose a slot based on availability
Once an appointment with a doctor is confirmed, no other patient should be able to schedule an appointment with the same doctor during the same time slot. This ensures proper scheduling and avoids conflicts
If Appointment Booking is successful, then the status should be CONFIRMED
Display success messages upon booking and error messages when applicable
Validation:
patientName: PatientName should contain at least one word. It can contain more than one word, each word separated by a single space. Each word should start with an uppercase alphabet followed by lowercase alphabets.
contactNumber: The contactNumber length should be equal to 10 and all the ten digits should not be the same.
gender: Gender should be either Male/Female/Others.
patientIssue : PatientIssues received should not be null or empty.
appointmentTime: Appointment time should be a future time between 10:00 AM to 8:00PM.
appointmentDate : Appointment date should be a present/future date.