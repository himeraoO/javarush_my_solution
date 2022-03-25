package com.javarush.task.task39.task3913;

import com.javarush.task.task39.task3913.query.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {

    private Path logDir;
    private List<LogInfo> listLogsInfo;
    private final SimpleDateFormat formatterGLOBAL = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);

    public LogParser(Path logDir) {
        this.logDir = logDir;
        scannerPathInLog();
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (checkedData(sLog.getDate(), after, before)) {
                ipSet.add(sLog.getIp());
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {

        Set<String> ipSet = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(user.equals(sLog.getName())) {
                if (checkedData(sLog.getDate(), after, before)) {
                    ipSet.add(sLog.getIp());
                }
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {

        Set<String> ipSet = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(event.equals(sLog.getEvent())) {
                if (checkedData(sLog.getDate(), after, before)) {
                    ipSet.add(sLog.getIp());
                }
            }
        }
        return ipSet;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {

        Set<String> ipSet = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(status.equals(sLog.getEventStatus())) {
                if (checkedData(sLog.getDate(), after, before)) {
                    ipSet.add(sLog.getIp());
                }
            }
        }
        return ipSet;
    }

    private void scannerPathInLog() {
        List<Path> files = new ArrayList<>();
        if (logDir != null) {
            listFiles(logDir, files);
        }
        listLogsInfo = new ArrayList<>();
        for (Path p : files) {
            if (p.toFile().getName().endsWith(".log")) {
                try (BufferedReader bufferedReader = new BufferedReader(new FileReader(p.toFile()))) {
                    while (bufferedReader.ready()) {
                        String s = bufferedReader.readLine();
                        if (s != null) {
                            String[] strings = s.split("\t");
                            String ip = strings[0];
                            String name = strings[1];
                            Date date = formatterGLOBAL.parse(strings[2]);
                            String eventAndNumberTask = strings[3];
                            String[] eventAndNumberTaskArr = eventAndNumberTask.split(" ");
                            Event event = stringToEvent(eventAndNumberTaskArr[0]);
                            int numberEvent = -1;
                            if (eventAndNumberTaskArr.length > 1) {
                                numberEvent = Integer.parseInt(eventAndNumberTaskArr[1]);
                            }
                            String statusString = strings[4];
                            Status status = stringToStatus(statusString);

                            listLogsInfo.add(new LogInfo(ip, name, date, event, numberEvent, status));
                        }
                    }
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private boolean checkedData(Date fromLog, Date after, Date before) {
        if ((after == null)) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }
//        if ((fromLog.getTime() >= after.getTime()) && (fromLog.getTime() <= before.getTime())) {
        if ((fromLog.getTime() > after.getTime()) && (fromLog.getTime() < before.getTime())) {
            return true;
        } else {
            return false;
        }
    }


    private void listFiles(Path path, List<Path> list) {
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
            for (Path entry : stream) {
                if (Files.isDirectory(entry)) {
                    listFiles(entry, list);
                }
                list.add(entry);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            users.add(sLog.getName());
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (checkedData(sLog.getDate(), after, before)) {
                users.add(sLog.getName());
            }
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (user.equals(sLog.getName())) {
                if (checkedData(sLog.getDate(), after, before)) {
                    events.add(sLog.getEvent());
                }
            }
        }
        return events.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (ip.equals(sLog.getIp())) {
                if (checkedData(sLog.getDate(), after, before)) {
                    users.add(sLog.getName());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.LOGIN)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    users.add(sLog.getName());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    users.add(sLog.getName());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.WRITE_MESSAGE)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    users.add(sLog.getName());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.SOLVE_TASK)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    users.add(sLog.getName());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.SOLVE_TASK)) {
                if (sLog.getEventNumber() == task) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        users.add(sLog.getName());
                    }
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.DONE_TASK)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    users.add(sLog.getName());
                }
            }
        }
        return users;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> users = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEvent().equals(Event.DONE_TASK)) {
                if (sLog.getEventNumber() == task)
                    if (checkedData(sLog.getDate(), after, before)) {
                        users.add(sLog.getName());
                    }
            }
        }
        return users;
    }

    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getName().equals(user)) {
                if (sLog.getEvent().equals(event)) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        dates.add(sLog.getDate());
                    }
                }
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
                if (sLog.getEventStatus().equals(Status.FAILED)) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        dates.add(sLog.getDate());
                    }
                }
            }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getEventStatus().equals(Status.ERROR)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    dates.add(sLog.getDate());
                }
            }
        }
        return dates;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date date = null;
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getName().equals(user)) {
                if (sLog.getEvent().equals(Event.LOGIN)) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        if((date == null) || (date.getTime() > sLog.getDate().getTime())){
                            date = sLog.getDate();
                        }
                    }
                }
            }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getName().equals(user)) {
                if (sLog.getEvent().equals(Event.SOLVE_TASK)) {
                    if (sLog.getEventNumber() == task) {
                        if (checkedData(sLog.getDate(), after, before)) {
                            if ((date == null) || (date.getTime() > sLog.getDate().getTime())) {
                                date = sLog.getDate();
                            }
                        }
                    }
                }
            }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getName().equals(user)) {
                if (sLog.getEvent().equals(Event.DONE_TASK)) {
                    if (sLog.getEventNumber() == task) {
                        if (checkedData(sLog.getDate(), after, before)) {
                            if ((date == null) || (date.getTime() > sLog.getDate().getTime())) {
                                date = sLog.getDate();
                            }
                        }
                    }
                }
            }
        }
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getName().equals(user)) {
                if (sLog.getEvent().equals(Event.WRITE_MESSAGE)) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        dates.add(sLog.getDate());
                    }
                }
            }
        }
        return dates;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (sLog.getName().equals(user)) {
                if (sLog.getEvent().equals(Event.DOWNLOAD_PLUGIN)) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        dates.add(sLog.getDate());
                    }
                }
            }
        }
        return dates;
    }

    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (checkedData(sLog.getDate(), after, before)) {
                events.add(sLog.getEvent());
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getIp().equals(ip)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    events.add(sLog.getEvent());
                }
            }
        }
        return events;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getName().equals(user)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    events.add(sLog.getEvent());
                }
            }
        }
        return events;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getEventStatus().equals(Status.FAILED)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    events.add(sLog.getEvent());
                }
            }
        }
        return events;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> events = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getEventStatus().equals(Status.ERROR)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    events.add(sLog.getEvent());
                }
            }
        }
        return events;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getEvent().equals(Event.SOLVE_TASK)) {
                if(sLog.getEventNumber() == task) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getEvent().equals(Event.DONE_TASK)) {
                if(sLog.getEventNumber() == task) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        i++;
                    }
                }
            }
        }
        return i;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getEvent().equals(Event.SOLVE_TASK)) {
                if(sLog.getEventNumber() != -1) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        map.put(sLog.getEventNumber(), getNumberOfAttemptToSolveTask(sLog.getEventNumber(), after, before));
                    }
                }
            }
        }
        return map;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        Map<Integer, Integer> map = new HashMap<>();
        for (LogInfo sLog : listLogsInfo) {
            if(sLog.getEvent().equals(Event.DONE_TASK)) {
                if(sLog.getEventNumber() != -1) {
                    if (checkedData(sLog.getDate(), after, before)) {
                        map.put(sLog.getEventNumber(), getNumberOfSuccessfulAttemptToSolveTask(sLog.getEventNumber(), after, before));
                    }
                }
            }
        }
        return map;
    }

    public Set<Date> getAllDate(Date after, Date before){
        Set<Date> dates = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
                if (checkedData(sLog.getDate(), after, before)) {
                    dates.add(sLog.getDate());
                }
            }
        return dates;
    }

    public Set<Status> getAllStatuses(Date after, Date before){
        Set<Status> statuses = new HashSet<>();
        for (LogInfo sLog : listLogsInfo) {
            if (checkedData(sLog.getDate(), after, before)) {
                statuses.add(sLog.getEventStatus());
            }
        }
        return statuses;
    }

    public Event stringToEvent(String s) {
        Event event = null;
        switch (s) {
            case "LOGIN":
                event = Event.LOGIN;
                break;
            case "DOWNLOAD_PLUGIN":
                event = Event.DOWNLOAD_PLUGIN;
                break;
            case "WRITE_MESSAGE":
                event = Event.WRITE_MESSAGE;
                break;
            case "SOLVE_TASK":
                event = Event.SOLVE_TASK;
                break;
            case "DONE_TASK":
                event = Event.DONE_TASK;
                break;
            default:
                break;
        }
        return event;
    }

    public Status stringToStatus(String s) {
        Status status = null;
        switch (s) {
            case "OK":
                status = Status.OK;
                break;
            case "FAILED":
                status = Status.FAILED;
                break;
            case "ERROR":
                status = Status.ERROR;
                break;
            default:
                break;
        }
        return status;
    }

    @Override
    public Set<Object> execute(String query) {
        if(query.equals("get ip") ||
                query.equals("get user") ||
                query.equals("get date") ||
                query.equals("get event") ||
                query.equals("get status")) {
            switch (query) {
                case "get ip":
                    return new HashSet<>(getUniqueIPs(null, null));
                case "get user":
                    return new HashSet<>(getAllUsers());
                case "get date":
                    return new HashSet<>(getAllDate(null, null));
                case "get event":
                    return new HashSet<>(getAllEvents(null, null));
                case "get status":
                    return new HashSet<>(getAllStatuses(null, null));
                default:
                    return null;
            }
        }else if(!query.contains(" and date between ")){
            String params1 = query.split(" = ")[1];
            String valueParams = params1.substring(1, params1.length()-1);

            String params2 = query.split(" = ")[0];
            String result = params2.split(" ")[1];
            String value = params2.split(" ")[3];

            return getAllResultForParam(result,value,valueParams);
        }else if(query.contains(" and date between ")){
            Date after = null;
            Date before = null;
            String[] arr1 = query.split(" = ");

            String result = arr1[0].split(" ")[1];
            String value = arr1[0].split(" ")[3];
            String[] arr2 = arr1[1].split(" and date between ");
            String params3 = arr2[0];
            String valueParams = params3.substring(1, params3.length()-1);

            String[] params4 = arr2[1].split(" and ");
            try {
                String af = params4[0].substring(1, params4[0].length()-1);
                after = formatterGLOBAL.parse(af);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            try {
                String bf = params4[1].substring(1, params4[1].length()-1);
                before = formatterGLOBAL.parse(bf);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            return getAllResultForParam(result,value,valueParams, after, before);
        }
        return null;
    }

    public Set<Object> getAllResultForParam(String result, String param, String valueParam, Date after, Date before ){
        Set<Object> results = new HashSet<>();
        Object params = null;
        if(param.equals("date")){
            try {
                params = formatterGLOBAL.parse(valueParam);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if(param.equals("event")){
            params = stringToEvent(valueParam);
        }else if (param.equals("status")){
            params = stringToStatus(valueParam);
        }else {
            params = valueParam;
        }

        for (LogInfo sLog : listLogsInfo) {
            if (getCurrentValue(sLog, param).equals(params)) {
                if (checkedData(sLog.getDate(), after, before)) {
                    results.add(getCurrentValue(sLog, result));
                }
            }
        }
        return results;
    }

    public Set<Object> getAllResultForParam(String result, String param, String valueParam ){
        Set<Object> results = new HashSet<>();
        Object params = null;
        if(param.equals("date")){
            try {
                params = formatterGLOBAL.parse(valueParam);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else
        if(param.equals("event")){
            params = stringToEvent(valueParam);
        }else

        if (param.equals("status")){
            params = stringToStatus(valueParam);
        }else {
            params = valueParam;
        }


        for (LogInfo sLog : listLogsInfo) {
            if (getCurrentValue(sLog, param).equals(params)) {
                    results.add(getCurrentValue(sLog, result));
            }
        }
        return results;
    }



    private abstract class StrategyGet{
        protected LogInfo logInfo;
        abstract  Object execute();
    }

    private class GetIpStrategy extends StrategyGet{

        public GetIpStrategy(LogInfo logInfo) {
            this.logInfo = logInfo;
        }

        @Override
        Object execute() {
            return logInfo.getIp();
        }
    }

    private class GetStatusStrategy extends StrategyGet{

        public GetStatusStrategy(LogInfo logInfo) {
            this.logInfo = logInfo;
        }

        @Override
        Object execute() {
            return logInfo.getEventStatus();
        }
    }

    private class GetUserStrategy extends StrategyGet{

        public GetUserStrategy(LogInfo logInfo) {
            this.logInfo = logInfo;
        }

        @Override
        Object execute() {
            return logInfo.getName();
        }
    }

    private class GetEventStrategy extends StrategyGet{

        public GetEventStrategy(LogInfo logInfo) {
            this.logInfo = logInfo;
        }

        @Override
        Object execute() {
            return logInfo.getEvent();
        }
    }

    private class GetDateStrategy extends StrategyGet{

        public GetDateStrategy(LogInfo logInfo) {
            this.logInfo = logInfo;
        }

        @Override
        Object execute() {
            return logInfo.getDate();
        }
    }

    private Object getCurrentValue(LogInfo logInfo, String field) {
        Object value = null;
        switch (field) {
            case "ip": {
                StrategyGet method = new GetIpStrategy(logInfo);
                value = method.execute();
                break;
            }
            case "user": {
                StrategyGet method = new GetUserStrategy(logInfo);
                value = method.execute();
                break;
            }
            case "date": {
                StrategyGet method = new GetDateStrategy(logInfo);
                value = method.execute();
                break;
            }
            case "event": {
                StrategyGet method = new GetEventStrategy(logInfo);
                value = method.execute();
                break;
            }
            case "status": {
                StrategyGet method = new GetStatusStrategy(logInfo);
                value = method.execute();
                break;
            }
        }
        return value;
    }

}