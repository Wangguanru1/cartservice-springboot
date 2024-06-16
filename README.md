## 仓库说明
武汉大学云计算课程附加实验，在 Online Boutique 项目中，将其中至少一个非 Java 实现的微服务，改写成SpringBoot的微服务，完成整体新项目Kubernetes中的部署，重新使用步骤2-6中的组件，完成调试、分析和管理。

本仓库对应cartservice(原C#)的springboot版本，在原项目环境可以正常运行

## 使用说明
1. 本地安装protoc(3.20.3)，添加bin目录至环境变量
2. 运行mvn compile，可以根据proto文件生成代码（可跳过）
3. 运行mvn package，创建jar包（可跳过）
4. 使用jar目录的Dockerfile制作镜像
5. 在实验环境中替换kubernetes-manifests.yaml中cartservice部分的image为你的镜像，修改memory大小为原先两倍
6. 重新运行