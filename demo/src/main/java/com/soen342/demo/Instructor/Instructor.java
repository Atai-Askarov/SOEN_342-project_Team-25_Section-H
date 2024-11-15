package com.soen342.demo.Instructor;

import java.util.ArrayList;
import com.soen342.demo.DateTime.*;
import com.soen342.demo.Service.*;
import com.soen342.demo.ServiceInterfaces.InstructorService;
import com.soen342.demo.ServiceInterfaces.OfferingService;
import com.soen342.demo.ServiceInterfaces.ScheduleService;
import com.soen342.demo.ServiceInterfaces.SeasonService;
import com.soen342.demo.ServiceInterfaces.TimeSlotService;
import com.soen342.demo.ServiceInterfaces.LessonService;
import com.soen342.demo.dto.InstructorDto;
import com.soen342.demo.dto.LessonDto;
import com.soen342.demo.dto.OfferingDto;
import com.soen342.demo.dto.ScheduleDto;
import com.soen342.demo.dto.SeasonDto;
import com.soen342.demo.dto.TimeSlotDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Instructor {
    private String phone_number;
    private String first_name;
    private String last_name;
    private List<String> city;
    private List<String> specialization; // Changed to ArrayList
    private Schedule availability;
    private String password;

    @Autowired
    final TimeSlotService timeSlotService = null;
    @Autowired
    final SeasonService seasonService = null;
    @Autowired
    final ScheduleService scheduleService = null;
    @Autowired
    final InstructorService instructorService = null;
    @Autowired
    final OfferingService offeringService = null;
    @Autowired
    final LessonService lessonService = null;

    private static int generateRandomId() {
        Random random = new Random();
        return random.nextInt(10000); // Generates a random integer between 0 and 9999
    }
    public void ViewLessons() {
        List<LessonDto> lessons = lessonService.getAllLessons();
        for (LessonDto lesson : lessons) {
            System.out.println(lesson.getLessonName());
        }
    }
    //Select the lesson that the instructor wants to accept
    // after that the lesson must undergo a series of checks to see if it is valid within the schedule
    public void acceptLesson(Lesson lesson, int instructor_id, int lesson_id, LocalDate start, LocalDate end, String day) {
        int OfferingIdGenerated = generateRandomId();
        OfferingDto offeringDto = new OfferingDto();
        
        for (String city : this.getCity()) {
            for (String specialization : this.getSpecialization()) {
                if (lesson.getLocation().getCity().equals(city) && lesson.getTimeSlot().getActivity().equals(specialization)) {
                    for( int i = 0; i < availability.getSeason().size(); i++){
                        if (availability.getSeason().get(i).isWithinDateInterval(new LocalDate[]{start, end}));
                            int capacity = lesson.getCapacity();
                            if (!lesson.getStatus().equals("available")){
                                System.out.println("Lesson is not available");
                            }
                            else{
                                if (capacity > 0){
                                    capacity -= 1;
                                    Season theOne = availability.getSeason().get(i);
                                    if(theOne.setTimeSlot(lesson.getTimeSlot(), day)){
                                        lesson.setCapacity(capacity);
                                        offeringDto.setInstructorId(instructor_id);
                                        offeringDto.setLessonId(lesson_id);
                                        offeringDto.setOfferingId(OfferingIdGenerated);
                                        offeringService.createOffering(offeringDto);
                                    }
                                else{
                                    System.out.println("Lesson is full");
                                }
                        }
                            
                        }
                    }
                    
                }
                else{
                    System.out.println("Lesson is not accepted");
                }
            }
        }
    }

    public List<InstructorDto> createInstructorDto() {
        List<InstructorDto> instructorDtos = new ArrayList<>();
        Schedule schedule = this.getAvailability();
        List<Season> seasons = schedule.getSeason();
        
        for (Season season : seasons) {
            int seasonIdGenerated = generateRandomId();
    
            List<List<TimeSlot>> timeslots = season.getDaysWeek();
            for (int day_index = 0; day_index < timeslots.size(); day_index++) {
                List<TimeSlot> day = timeslots.get(day_index);
                for (TimeSlot timeSlot : day) {
                    int timeslotIdGenerated = generateRandomId();
                    for (String city : this.getCity()) {
                        for (String specialization : this.getSpecialization()) {
    
                            TimeSlotDto timeSlotDto = new TimeSlotDto();
                            timeSlotDto.setTimeslot_id(timeslotIdGenerated);
                            timeSlotDto.setWeekday(day_index);
                            timeSlotDto.setStart_time(timeSlot.getStart());
                            timeSlotDto.setEnd_time(timeSlot.getEnd());
                            timeSlotDto.setActivity(timeSlot.getActivity());
                            timeSlotService.createTimeSlot(timeSlotDto);
    
                            SeasonDto seasonDto = new SeasonDto();
                            seasonDto.setSeason_id(seasonIdGenerated);
                            seasonDto.setStart_date(season.getStartDate());
                            seasonDto.setEnd_date(season.getEndDate());
                            seasonDto.setTimeslot_id(timeSlotDto.getTimeslot_id());
                            seasonService.createSeason(seasonDto);
    
                            ScheduleDto scheduleDto = new ScheduleDto();
                            scheduleDto.setSchedule_id(generateRandomId());
                            scheduleDto.setSeason_id(seasonDto.getSeason_id());
                            scheduleDto.setOwner_id(generateRandomId());
                            scheduleService.createSchedule(scheduleDto);
    
                            InstructorDto instructorDto = new InstructorDto();
                            instructorDto.setInstructor_id(scheduleDto.getOwner_id());
                            instructorDto.setFirst_name(this.getFirst_name());
                            instructorDto.setLast_name(this.getLast_name());
                            instructorDto.setPhone_number(this.getPhone_number());
                            instructorDto.setCity(city);
                            instructorDto.setSpecialization_name(specialization);
                            instructorDto.setPassword(this.getPassword());
                            instructorDto.setSchedule_id(scheduleDto.getSchedule_id());
                            instructorDto.setSeason_id(seasonDto.getSeason_id());
                            instructorService.createInstructor(instructorDto);
                            instructorDtos.add(instructorDto);
                        }
                    }
                }
            }
        }
    
        return instructorDtos;
    }
}