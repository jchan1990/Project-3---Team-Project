package com.example.qube.jjspost.models.breaking_news;


import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BreakingNews {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<Result> results = new ArrayList<Result>();

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     *
     * @param copyright
     * The copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    /**
     *
     * @return
     * The numResults
     */
    public Integer getNumResults() {
        return numResults;
    }

    /**
     *
     * @param numResults
     * The num_results
     */
    public void setNumResults(Integer numResults) {
        this.numResults = numResults;
    }

    /**
     *
     * @return
     * The results
     */
    public List<Result> getResults() {
        return results;
    }

    /**
     *
     * @param results
     * The results
     */
    public void setResults(List<Result> results) {
        this.results = results;
    }


    public class Multimedium {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("format")
        @Expose
        private String format;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("subtype")
        @Expose
        private String subtype;
        @SerializedName("caption")
        @Expose
        private String caption;
        @SerializedName("copyright")
        @Expose
        private String copyright;

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The format
         */
        public String getFormat() {
            return format;
        }

        /**
         *
         * @param format
         * The format
         */
        public void setFormat(String format) {
            this.format = format;
        }

        /**
         *
         * @return
         * The height
         */
        public Integer getHeight() {
            return height;
        }

        /**
         *
         * @param height
         * The height
         */
        public void setHeight(Integer height) {
            this.height = height;
        }

        /**
         *
         * @return
         * The width
         */
        public Integer getWidth() {
            return width;
        }

        /**
         *
         * @param width
         * The width
         */
        public void setWidth(Integer width) {
            this.width = width;
        }

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         * The subtype
         */
        public String getSubtype() {
            return subtype;
        }

        /**
         *
         * @param subtype
         * The subtype
         */
        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        /**
         *
         * @return
         * The caption
         */
        public String getCaption() {
            return caption;
        }

        /**
         *
         * @param caption
         * The caption
         */
        public void setCaption(String caption) {
            this.caption = caption;
        }

        /**
         *
         * @return
         * The copyright
         */
        public String getCopyright() {
            return copyright;
        }

        /**
         *
         * @param copyright
         * The copyright
         */
        public void setCopyright(String copyright) {
            this.copyright = copyright;
        }

    }


    public class RelatedUrl {

        @SerializedName("suggested_link_text")
        @Expose
        private String suggestedLinkText;
        @SerializedName("url")
        @Expose
        private String url;

        /**
         *
         * @return
         * The suggestedLinkText
         */
        public String getSuggestedLinkText() {
            return suggestedLinkText;
        }

        /**
         *
         * @param suggestedLinkText
         * The suggested_link_text
         */
        public void setSuggestedLinkText(String suggestedLinkText) {
            this.suggestedLinkText = suggestedLinkText;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

    }

    public class Result {

        @SerializedName("section")
        @Expose
        private String section;
        @SerializedName("subsection")
        @Expose
        private String subsection;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("abstract")
        @Expose
        private String _abstract;
        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("short_url")
        @Expose
        private String shortUrl;
        @SerializedName("byline")
        @Expose
        private String byline;
        @SerializedName("thumbnail_standard")
        @Expose
        private String thumbnailStandard;
        @SerializedName("item_type")
        @Expose
        private String itemType;
        @SerializedName("source")
        @Expose
        private String source;
        @SerializedName("updated_date")
        @Expose
        private String updatedDate;
        @SerializedName("created_date")
        @Expose
        private String createdDate;
        @SerializedName("published_date")
        @Expose
        private String publishedDate;
        @SerializedName("material_type_facet")
        @Expose
        private String materialTypeFacet;
        @SerializedName("kicker")
        @Expose
        private String kicker;
        @SerializedName("headline")
        @Expose
        private String headline;
        @SerializedName("des_facet")
        @Expose
        private List<String> desFacet = new ArrayList<String>();
        @SerializedName("org_facet")
        @Expose
        private String orgFacet;
        @SerializedName("per_facet")
        @Expose
        private List<String> perFacet = new ArrayList<String>();
        @SerializedName("geo_facet")
        @Expose
        private List<String> geoFacet = new ArrayList<String>();
        @SerializedName("blog_name")
        @Expose
        private String blogName;
        @SerializedName("related_urls")
        @Expose
        private List<RelatedUrl> relatedUrls = new ArrayList<RelatedUrl>();
        @SerializedName("multimedia")
        @Expose
        private List<Multimedium> multimedia = new ArrayList<Multimedium>();

        /**
         *
         * @return
         * The section
         */
        public String getSection() {
            return section;
        }

        /**
         *
         * @param section
         * The section
         */
        public void setSection(String section) {
            this.section = section;
        }

        /**
         *
         * @return
         * The subsection
         */
        public String getSubsection() {
            return subsection;
        }

        /**
         *
         * @param subsection
         * The subsection
         */
        public void setSubsection(String subsection) {
            this.subsection = subsection;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The _abstract
         */
        public String getAbstract() {
            return _abstract;
        }

        /**
         *
         * @param _abstract
         * The abstract
         */
        public void setAbstract(String _abstract) {
            this._abstract = _abstract;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The shortUrl
         */
        public String getShortUrl() {
            return shortUrl;
        }

        /**
         *
         * @param shortUrl
         * The short_url
         */
        public void setShortUrl(String shortUrl) {
            this.shortUrl = shortUrl;
        }

        /**
         *
         * @return
         * The byline
         */
        public String getByline() {
            return byline;
        }

        /**
         *
         * @param byline
         * The byline
         */
        public void setByline(String byline) {
            this.byline = byline;
        }

        /**
         *
         * @return
         * The thumbnailStandard
         */
        public String getThumbnailStandard() {
            return thumbnailStandard;
        }

        /**
         *
         * @param thumbnailStandard
         * The thumbnail_standard
         */
        public void setThumbnailStandard(String thumbnailStandard) {
            this.thumbnailStandard = thumbnailStandard;
        }

        /**
         *
         * @return
         * The itemType
         */
        public String getItemType() {
            return itemType;
        }

        /**
         *
         * @param itemType
         * The item_type
         */
        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        /**
         *
         * @return
         * The source
         */
        public String getSource() {
            return source;
        }

        /**
         *
         * @param source
         * The source
         */
        public void setSource(String source) {
            this.source = source;
        }

        /**
         *
         * @return
         * The updatedDate
         */
        public String getUpdatedDate() {
            return updatedDate;
        }

        /**
         *
         * @param updatedDate
         * The updated_date
         */
        public void setUpdatedDate(String updatedDate) {
            this.updatedDate = updatedDate;
        }

        /**
         *
         * @return
         * The createdDate
         */
        public String getCreatedDate() {
            return createdDate;
        }

        /**
         *
         * @param createdDate
         * The created_date
         */
        public void setCreatedDate(String createdDate) {
            this.createdDate = createdDate;
        }

        /**
         *
         * @return
         * The publishedDate
         */
        public String getPublishedDate() {
            return publishedDate;
        }

        /**
         *
         * @param publishedDate
         * The published_date
         */
        public void setPublishedDate(String publishedDate) {
            this.publishedDate = publishedDate;
        }

        /**
         *
         * @return
         * The materialTypeFacet
         */
        public String getMaterialTypeFacet() {
            return materialTypeFacet;
        }

        /**
         *
         * @param materialTypeFacet
         * The material_type_facet
         */
        public void setMaterialTypeFacet(String materialTypeFacet) {
            this.materialTypeFacet = materialTypeFacet;
        }

        /**
         *
         * @return
         * The kicker
         */
        public String getKicker() {
            return kicker;
        }

        /**
         *
         * @param kicker
         * The kicker
         */
        public void setKicker(String kicker) {
            this.kicker = kicker;
        }

        /**
         *
         * @return
         * The headline
         */
        public String getHeadline() {
            return headline;
        }

        /**
         *
         * @param headline
         * The headline
         */
        public void setHeadline(String headline) {
            this.headline = headline;
        }

        /**
         *
         * @return
         * The desFacet
         */
        public List<String> getDesFacet() {
            return desFacet;
        }

        /**
         *
         * @param desFacet
         * The des_facet
         */
        public void setDesFacet(List<String> desFacet) {
            this.desFacet = desFacet;
        }

        /**
         *
         * @return
         * The orgFacet
         */
        public String getOrgFacet() {
            return orgFacet;
        }

        /**
         *
         * @param orgFacet
         * The org_facet
         */
        public void setOrgFacet(String orgFacet) {
            this.orgFacet = orgFacet;
        }

        /**
         *
         * @return
         * The perFacet
         */
        public List<String> getPerFacet() {
            return perFacet;
        }

        /**
         *
         * @param perFacet
         * The per_facet
         */
        public void setPerFacet(List<String> perFacet) {
            this.perFacet = perFacet;
        }

        /**
         *
         * @return
         * The geoFacet
         */
        public List<String> getGeoFacet() {
            return geoFacet;
        }

        /**
         *
         * @param geoFacet
         * The geo_facet
         */
        public void setGeoFacet(List<String> geoFacet) {
            this.geoFacet = geoFacet;
        }

        /**
         *
         * @return
         * The blogName
         */
        public String getBlogName() {
            return blogName;
        }

        /**
         *
         * @param blogName
         * The blog_name
         */
        public void setBlogName(String blogName) {
            this.blogName = blogName;
        }

        /**
         *
         * @return
         * The relatedUrls
         */
        public List<RelatedUrl> getRelatedUrls() {
            return relatedUrls;
        }

        /**
         *
         * @param relatedUrls
         * The related_urls
         */
        public void setRelatedUrls(List<RelatedUrl> relatedUrls) {
            this.relatedUrls = relatedUrls;
        }

        /**
         *
         * @return
         * The multimedia
         */
        public List<Multimedium> getMultimedia() {
            return multimedia;
        }

        /**
         *
         * @param multimedia
         * The multimedia
         */
        public void setMultimedia(List<Multimedium> multimedia) {
            this.multimedia = multimedia;
        }

    }


}