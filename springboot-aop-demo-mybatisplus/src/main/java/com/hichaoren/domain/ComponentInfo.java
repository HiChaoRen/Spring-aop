package com.hichaoren.domain;

import lombok.Data;

/**
 * Created by HiChaoRen on 2023-3-14.
 */
@Data
public class ComponentInfo {

    private Integer id;
    private String name;
    private String desc;
    private String mvnGroup;
    private String mvnArtifact;
    private Integer type;
    private Integer componentId;
    private String groupName;
    private String appVersion;

    private Integer maintainerId;
    private String maintainer;

    private String version;
    private String publishTime;
    private String snapshotVersion;
    private String snapshotPublishTime;


}
