FROM java:8
RUN javac WidgetsApplication.java
CMD ["java", "Main"]