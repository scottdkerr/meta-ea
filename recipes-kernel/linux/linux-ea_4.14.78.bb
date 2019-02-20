# Copyright (C) 2017 Embedded Artists AB
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided by Embedded Artists but based on NXP's kernel"
DESCRIPTION = "Linux Kernel for Embedded Artists i.MX based COM boards. \
The kernel is based on the kernel provided by NXP."

require recipes-kernel/linux/linux-imx.inc

SRC_URI = "git://github.com/scottdkerr/linux-imx.git;protocol=git;branch=${SRCBRANCH}"

LOCALVERSION = "-1.0.0"
SRCBRANCH = "ea_4.14.78"
SRCREV = "65e4f5c5ab06b5a3207fb1e7bcb24792d9850323"
DEPENDS += "lzop-native bc-native"


DEFAULT_PREFERENCE = "1"

addtask copy_defconfig after do_unpack before do_preconfigure
do_copy_defconfig () {
    install -d ${B}
    # copy latest ea_imx_defconfig to use
    cp ${S}/arch/arm/configs/ea_imx_defconfig ${B}/.config
    cp ${S}/arch/arm/configs/ea_imx_defconfig ${B}/../defconfig
}

COMPATIBLE_MACHINE = "(mx6|mx6ul|mx7)"

