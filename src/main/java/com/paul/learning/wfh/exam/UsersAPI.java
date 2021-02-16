package com.paul.learning.wfh.exam;

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

        // Loop through each page.
        while (startPage <= totalPages) {
            try {
                LOGGER.info("Processing Page: {}", startPage);
                URL obj = new URL(url);
                HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                con.setRequestMethod("GET");
                InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());
                BufferedReader in = new BufferedReader(inputStreamReader);
                while ((response = in.readLine()) != null) {
                    totalPages = processResponseWithGson(response, totalPages, userNames, threshold);
                }
                in.close();
                startPage++;
            } catch (Exception ex) {
                ex.printStackTrace();
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
        JsonResponse json = gson.fromJson(response, JsonResponse.class);

        if (json != null) {

            // Extract total_pages from JSON response and set as the total pages.
            Integer total = json.getTotalPages();

            if (total < totalPages) {
                totalPages = total;
            }

            List<Data> dataList = Optional.ofNullable(json.getData())
                    .orElseGet(ArrayList::new);

            for (Data data : dataList) {
                // Extract the Submission Count.
                Integer submissionCount = data.getSubmissionCount();

                // If exceeds thresh hold add in the username.
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
