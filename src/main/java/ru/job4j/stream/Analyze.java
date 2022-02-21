package ru.job4j.stream;

import ru.job4j.list.ConvertMatrix2List;

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(Collection::stream)
                .mapToDouble(Subject::getScore)
                .average().orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                pupil.getSubjects().stream()
                        .mapToDouble(Subject::getScore)
                        .average()
                        .orElse(0D)))
                .collect(Collectors.toList()
                );
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(Collection::stream)
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(name -> new Tuple(name.getKey(), name.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(),
                        pupil.getSubjects().stream()
                                .mapToDouble(Subject::getScore)
                                .sum()))
                .max(Comparator
                        .comparing(x -> (int) x.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.map(Pupil::getSubjects)
                .flatMap(Collection::stream)
                .collect(Collectors
                        .groupingBy(Subject::getName,
                                LinkedHashMap::new,
                                Collectors.summingDouble(Subject::getScore)))
                .entrySet().stream()
                .map(name -> new Tuple(name.getKey(), name.getValue()))
                .max(Comparator
                        .comparing(x -> (int) x.getScore()))
                .orElse(null);
    }
}