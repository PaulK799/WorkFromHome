package com.paul.learning.wfh.exam.pipeline;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 */
public class UsersAPI {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersAPI.class);

    /**
     *
     */
    private UsersAPI() {
        // Private Constructor.
    }

    /*
     * Complete the 'getUsernames' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts INTEGER threshold as parameter.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/article_users?page=<pageNumber>
     */

    public static List<String> getUsernames(int threshold) {
        List<String> userNames = new ArrayList<>();


        int startPage = 0;
        int totalPages = Integer.MAX_VALUE;
        String url = "https://jsonmock.hackerrank.com/api/article_users?page=" + startPage;
        String response;

        // Break condition in processing.
        while (startPage <= totalPages) {
            try {
                LOGGER.info("Processing Page: {}", startPage);
                URL obj = new URL(url);
                // Setup HTTP GET Request
                HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
                connection.setRequestMethod("GET");
                connection.setRequestProperty("Content-Type", "application/json; utf-8");

                // Read from open connection.
                InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
                BufferedReader buffy = new BufferedReader(inputStreamReader);

                // Read response from the BufferedReader.
                while ((response = buffy.readLine()) != null) {
                    // Process using GSON to convert String JSON response into JsonResponse POJO.
                    totalPages = processResponseWithGson(response, totalPages, userNames, threshold);
                }

                // Close open connection
                buffy.close();

                // Increment page.
                startPage++;
            } catch (Exception exception) {
                LOGGER.error("Exception found: {0}", exception);
            }
        }

        return userNames;
    }

    /**
     * Process the {@link JsonResponse} using {@link Gson}.
     *
     * @param response   - The {@link String} being processed.
     * @param totalPages - The total pages to be processed.
     * @param userNames  - A list of  {@link String} usernames to be updated.
     * @param threshold  - The threshold for adding a person to the list of usernames.
     */
    public static Integer processResponseWithGson(String response, Integer totalPages, List<String> userNames, Integer threshold) {
        // Parse JSON response using JSON.
        Gson gson = new Gson();

        // Parse using the JsonResponse defined per the schema.
        JsonResponse jsonResponse = gson.fromJson(response, JsonResponse.class);
        if (jsonResponse != null) {
            // Extract total_pages from JSON response and set as the total pages.
            Integer total = jsonResponse.getTotalPages();

            // Set the total page only if its less than the totalPages previously extracted.
            if (total < totalPages) {
                totalPages = total;
            }

            // Extract Data from the JSON response.
            List<Data> dataList = Optional.ofNullable(jsonResponse.getData())
                    .orElseGet(ArrayList::new);

            // Process each entry
            for (Data data : dataList) {
                // Extract the Submission Count.
                Integer submissionCount = data.getSubmissionCount();

                // If exceeds thresh hold add in the username, add to list of usernames.
                if (submissionCount > threshold) {
                    String username = data.getUsername();
                    userNames.add(username);
                }
            }
        }

        return totalPages;
    }

    /**
     * Pojo class for the {@link JsonResponse} stored in the JSON response.
     */
    private class JsonResponse {
        private String page;

        @SerializedName("per_page")
        private Integer perPage;

        private Integer total;

        @SerializedName("total_pages")
        private Integer totalPages;

        private List<Data> data;

        public String getPage() {
            return page;
        }

        public void setPage(String page) {
            this.page = page;
        }

        public Integer getPerPage() {
            return perPage;
        }

        public void setPerPage(Integer perPage) {
            this.perPage = perPage;
        }

        public Integer getTotal() {
            return total;
        }

        public void setTotal(Integer total) {
            this.total = total;
        }

        public Integer getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(Integer totalPages) {
            this.totalPages = totalPages;
        }

        public List<Data> getData() {
            return data;
        }

        public void setData(List<Data> data) {
            this.data = data;
        }
    }

    /**
     * Pojo class for the {@link Data} stored in the JSON response.
     */
    private class Data {

        private Integer id;
        private String username;
        private String about;
        private Integer submitted;

        @SerializedName("updated_at")
        private String updatedAt;

        @SerializedName("submission_count")
        private Integer submissionCount;

        @SerializedName("comment_count")
        private Integer commentCount;

        @SerializedName("created_at")
        private long createdAt;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAbout() {
            return about;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public Integer getSubmitted() {
            return submitted;
        }

        public void setSubmitted(Integer submitted) {
            this.submitted = submitted;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }

        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public Integer getSubmissionCount() {
            return submissionCount;
        }

        public void setSubmissionCount(Integer submissionCount) {
            this.submissionCount = submissionCount;
        }

        public Integer getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(Integer commentCount) {
            this.commentCount = commentCount;
        }

        public long getCreatedAt() {
            return createdAt;
        }

        public void setCreatedAt(long createdAt) {
            this.createdAt = createdAt;
        }
    }
}
